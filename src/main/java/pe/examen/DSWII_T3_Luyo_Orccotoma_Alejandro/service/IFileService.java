package pe.examen.DSWII_T3_Luyo_Orccotoma_Alejandro.service;

import org.springframework.web.multipart.MultipartFile;


public interface IFileService {

    void guardarArchivo(MultipartFile archivo) throws Exception;

}