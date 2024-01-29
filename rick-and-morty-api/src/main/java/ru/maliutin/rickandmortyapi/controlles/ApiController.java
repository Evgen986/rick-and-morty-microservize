package ru.maliutin.rickandmortyapi.controlles;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.maliutin.rickandmortyapi.services.ServiceApi;

@RestController
public class ApiController {

    private final ServiceApi serviceApi;

    public ApiController(ServiceApi serviceApi) {
        this.serviceApi = serviceApi;
    }

    @GetMapping("/")
    public ResponseEntity<String> getCharacters(
            @RequestParam(value = "page", required = false) String page){
        if (page != null){
            return ResponseEntity.ok().body(serviceApi.getAllCharacters(page));
        }
        return ResponseEntity.ok().body(serviceApi.getAllCharacters());
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getCharacter(@PathVariable("id") Integer id){
        return ResponseEntity.ok().body(serviceApi.getHero(id));
    }
}
