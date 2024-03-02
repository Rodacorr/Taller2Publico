package CapaGrafica.Controladores;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import CapaGrafica.VentanaListadoAsignaturas;
import CapaGrafica.VentanaRegistrarAsignatura;
import CapaLogica.IFachada;
import CapaLogica.Exceptions.AsignaturaYaExisteException;
import CapaLogica.Exceptions.AsignaturasCompletaException;
import CapaLogica.Exceptions.DicAsignaturasVacioException;
import CapaLogica.VO.voAsignatura;

public class ControladorListadoAsignaturas {

	private VentanaListadoAsignaturas ventana;
	private IFachada fachada;

	public ControladorListadoAsignaturas(VentanaListadoAsignaturas ven) {
		this.ventana = ven;
		try {
			fachada = (IFachada)
					Naming.lookup("//localhost:1099/fachada");
		} catch (MalformedURLException e) {
			JOptionPane.showMessageDialog(null, "No se pudo establecer conexion con el servidor");
			e.printStackTrace();
		} catch (RemoteException e) {
			JOptionPane.showMessageDialog(null, "No se pudo establecer conexion con el servidor");
			e.printStackTrace();
		} catch (NotBoundException e) {
			JOptionPane.showMessageDialog(null, "No se pudo establecer conexion con el servidor");
		}

	}


	public void listarAsignaturas() {
		ArrayList<voAsignatura> listaAsignaturas = null; // Inicializamos a null
		try {
			listaAsignaturas = fachada.listarAsignaturas();
			Object[][] data = new Object [listaAsignaturas.size()][3];
			int numFila = 0;
			for(voAsignatura vo : listaAsignaturas) {
				Object [] fila = {vo.getCodigo(),vo.getNombre(),vo.getDescripcion()};
				data[numFila] = fila;
				numFila++;
			}
			ventana.setearDatos(data);
		} catch (DicAsignaturasVacioException exc) {
			ventana.mostrarMensajeError(exc.darMensaje());
		} catch (RemoteException exc) {
			ventana.mostrarMensajeError(exc.getMessage());
		}

	}
}
