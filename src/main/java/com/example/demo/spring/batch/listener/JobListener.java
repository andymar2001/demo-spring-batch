package com.example.demo.spring.batch.listener;


import com.example.demo.spring.batch.model.Person;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Log4j2
@Component
@RequiredArgsConstructor
public class JobListener extends JobExecutionListenerSupport {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public void afterJob(JobExecution jobExecution) {
        if (jobExecution.getStatus() == BatchStatus.COMPLETED) {
            log.info("Finalizo el Job!, verificar resultados");

            jdbcTemplate.query("SELECT nombre, apellido1, telefono from tp_personas", (rs, row) -> Person.builder()
                                    .name(rs.getString(1))
                                    .lastName1(rs.getString(2))
                                    .phone(rs.getString(3))
                                    .build())
                    .forEach(person -> log.info("Registro <{}>", person));
        }
    }


}
