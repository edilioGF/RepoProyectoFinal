package logico;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Controladora control = new Controladora();

		Graduado grad = new Graduado("001", "J", "G", "00", "M", "RD", "RD", false, "ISC");
		Obrero obr = new Obrero("002", "Ed", "Gr", "00", "M", "RD", "RD", false, "plomero");
		Empresa emp = new Empresa("001", "EM", "RD", "Soft");

		Empleo empleo = new Empleo("001", "Ingeniero", 5, "Gerente", 12500, 0, 12, false, "esp", 5, false, false, true,
				false, false, "", "ISC", "");
		Empleo emp2 = new Empleo("002", "Plomero", 1, "Mano de obra", 30000, 0, 12, false, "esp", 3, false, false,
				false, false, true, "", "", "plomero");

		Solicitud solicitud = new Solicitud("001", grad, "esp", false, false, 5, true, false);
		Solicitud sol2 = new Solicitud("002", obr, "esp", false, false, 5, true, false);

		grad.getMisSolicitudes().add(solicitud);
		obr.getMisSolicitudes().add(sol2);
		emp.getMisEmpleos().add(empleo);
		emp.getMisEmpleos().add(emp2);
		empleo.getMisSolicitudes().add(solicitud);
		emp2.getMisSolicitudes().add(sol2);

		control.addSolicitante(grad);
		control.addSolicitante(obr);
		control.addSolicitud(solicitud);
		control.addSolicitud(sol2);
		control.addEmpresa(emp);
		control.addEmpleo(empleo);
		control.addEmpleo(emp2);

		control.match();

		System.out.println(empleo.getVacantes());
		System.out.println(solicitud.isSatisfecha());
		System.out.println(emp2.getVacantes());
	}
}
