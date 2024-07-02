package pe.examen.DSWII_T3_Luyo_Orccotoma_Alejandro.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class FileService implements IFileService {

    private final Path pathFolder = Paths.get("uploads");

    @PostConstruct
    public void init() {
        try {
            Files.createDirectories(pathFolder);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize storage", e);
        }
    }

    @Override
    public void guardarArchivo(MultipartFile archivo) throws Exception {
        if (!archivo.getOriginalFilename().endsWith(".png")) {
            throw new RuntimeException("Only PNG files are allowed.");
        }
        Files.copy(archivo.getInputStream(),
                this.pathFolder.resolve(archivo.getOriginalFilename()),
                StandardCopyOption.REPLACE_EXISTING);
    }

}
