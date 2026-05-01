package com.lorranpds.vitaflow.medical_registry;

import com.lorranpds.vitaflow.medical_registry.cliente.Loja;
import com.lorranpds.vitaflow.medical_registry.factories.MoveisFactory;
import com.lorranpds.vitaflow.medical_registry.factories.impl.VitorianoMoveisFactory;

public class MedicalRegistryApplication {
	public static void main(String[] args) {
		MoveisFactory factory = new VitorianoMoveisFactory();
        Loja minhaLoja = new Loja(factory);

		minhaLoja.exibirConjunto();
	}

}
