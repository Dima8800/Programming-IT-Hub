package ithub.png.imagesquarer.routes;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/img")
public class imgController {

    private final convertService service;

    public imgController(convertService Service) {
        service = Service;
    }


    @PostMapping(value = "/convert", consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] convert(@RequestParam("file") MultipartFile file,
                          @RequestParam("number") int size) throws IOException {
        return service.convert(file, size);
    }
}
