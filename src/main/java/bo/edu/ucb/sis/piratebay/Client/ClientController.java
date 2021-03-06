package bo.edu.ucb.sis.piratebay.Client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/clients")
public class ClientController {

    private ClientMapper clientMapper;

    @Autowired
    public ClientController(ClientMapper clientMapper) {
        this.clientMapper = clientMapper;
    }

    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ClientDTO> createClient(@RequestBody ClientDTO clientDTO) {
        System.out.println(clientDTO);
        clientMapper.create(clientDTO);
        return new ResponseEntity<>(clientDTO, HttpStatus.OK);
    }
}
