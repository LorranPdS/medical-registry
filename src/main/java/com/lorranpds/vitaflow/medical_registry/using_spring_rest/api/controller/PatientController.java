package com.lorranpds.vitaflow.medical_registry.using_spring_rest.api.controller;

import com.lorranpds.vitaflow.medical_registry.using_spring_rest.api.dto.PatientRegistrationCommand;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.api.dto.PatientRegistrationMapper;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.api.dto.PatientRegistrationRequest;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.api.dto.PatientRegistrationResponse;
import com.lorranpds.vitaflow.medical_registry.using_spring_rest.domain.service.PatientRegistryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/patients")
@RequiredArgsConstructor
public class PatientController{

    private static final String PACIENTE_REGISTRADO_COM_SUCESSO = "Paciente registrado com sucesso. Os serviços em background foram iniciados.";
    private final PatientRegistrationMapper mapper;
    private final PatientRegistryService patientService;

    @PostMapping
    public ResponseEntity<PatientRegistrationResponse> register(@RequestBody PatientRegistrationRequest request){
        PatientRegistrationCommand patientRegistrationCommand = mapper.toCommand(request);

        // Chama o caso de uso principal
        String recordId = patientService.registerNewPatient(patientRegistrationCommand);

        // Retorna 201 Created para o cliente rapidamente
        PatientRegistrationResponse response = new PatientRegistrationResponse(
                recordId, PACIENTE_REGISTRADO_COM_SUCESSO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}