package integrador2.Service;

import integrador2.DTO.EstadisticaCarreraDTO;
import integrador2.Repository.Interfaces.CarreraRepository;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Service
public class ReportService {

    @Autowired
    private CarreraRepository carreraRepository;

    public void generarReporteCSV(String filePath) throws IOException {
        List<EstadisticaCarreraDTO> estadisticas = carreraRepository.obtenerEstadisticas();

        try (PrintWriter pw = new PrintWriter(new File(filePath))) {
            pw.println("Carrera,Año,Inscriptos,Egresados");
            for (EstadisticaCarreraDTO e : estadisticas) {
                pw.println(e.getCarrera() +  "," + e.getInscriptos() + "," + e.getEgresados());
            }
        }
    }
}