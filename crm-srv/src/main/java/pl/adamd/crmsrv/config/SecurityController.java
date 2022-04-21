package pl.adamd.crmsrv.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:4200")
public class SecurityController {

        @PostMapping("/login")
        public LoggedUserDto login(){
            SecurityContext securityContext = SecurityContextHolder.getContext();
            Authentication authentication = securityContext.getAuthentication();
            String username = authentication.getName();
            String role = authentication.getAuthorities()
                    .stream()
                    .findFirst()
                    .orElseThrow()
                    .getAuthority();
            return new LoggedUserDto(username, role);
        }
}
