package br.com.felipemeireles.todolist.filter;

import java.io.IOException;
import java.util.Base64;

import br.com.felipemeireles.todolist.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import at.favre.lib.crypto.bcrypt.BCrypt;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class FilterTaskAuth extends OncePerRequestFilter {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        var servletPath = request.getServletPath();
        if (servletPath.startsWith("/tasks/")) {

            // Pegar a auatenticação (usuário e senha)
            var authorization = request.getHeader("Authorization");

            var authEnconded = authorization.substring("Basic".length()).trim();

            byte[] authDecode = Base64.getDecoder().decode(authEnconded);

            var authString = new String(authDecode);

            // ["emersonpessoa","12345"]
            String[] credentials = authString.split(":");
            String username = credentials[0];
            String password = credentials[1];

            // System.out.println(username);
            // System.out.println(password);

            // Validar usuário
            var user = this.usuarioRepository.findByNomeUsuario(username);

            if (user == null) {
                response.sendError(401);
            } else {

                // Validar senha
                var passwordVerify = BCrypt.verifyer().verify(password.toCharArray(), user.getSenha());

                if (passwordVerify.verified) {
                    // Segue viagem
                    request.setAttribute("idUser", user.getId());
                    filterChain.doFilter(request, response);
                } else {

                    response.sendError(401);

                }
            }
        } else {
            filterChain.doFilter(request, response);
        }

    }

}