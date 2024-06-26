package med.voll.api.domain.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface MedicoRepository extends JpaRepository<Medico, Long> {

    Page<Medico> findByActivoTrue(Pageable paginacion);


    @Query("SELECT m FROM Medico m WHERE m.especialidad = :especialidad AND m.id NOT IN " +
            "(SELECT c.medico.id FROM Consulta c WHERE c.fecha = :fecha)")
    Medico seleccionarMedicoConEspecialidadEnFecha(@Param("especialidad") Especialidad especialidad,
                                                   @Param("fecha") LocalDateTime fecha);

   // @Query("""
   //         select m from Medico m
   //         where m.activo= 1
   //         and
    //        m.especialidad=:especialidad
    //        and
    //        m.id not in(
     //           select c.medico.id from Consulta c
     //           where
      //          c.fecha=:fecha
     //       )
     //       order by rand()
      //      limit 1
      //      """)
    //Medico seleccionarMedicoConEspecialidadEnFecha(Especialidad especialidad, LocalDateTime fecha);


    @Query("""
            select m.activo 
            from Medico m
            where m.id=:idMedico
            """)
    Boolean findActivoById(Long idMedico);
}
