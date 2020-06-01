package company.app.colegioBack.util;

public class Constantes {

	public static final Integer valTransaccionNoEncontro = 0; // No se encontro registro buscado
	public static final Integer valTransaccionOk = 1; // Toda la transaccion se realizo correctamente
	public static final Integer valTransaccionError = 2; // Fallo una parte de la transaccion

	// Modulo
	public static final String msgListarXPerfilModuloOk = "Modulos listados correctamente";
	public static final String msgListarXPerfilModuloError = "Error al listar modulos por perfil";

	// Alumno
	public static final String msgListarAlumnosOk = "Alumnos listados correctamente";
	public static final String msgListarAlumnosError = "Error al listar los alumnos";
	public static final String msgRegistrarAlumnoOk ="El alumno se ha registrado con éxito!";
	public static final String msgRegistrarAlumnoError= "Error al registrar al alumno en la Base de Datos";

	// Profesor
	public static final String msgListarProfesorOk = "Profesores listados correctamente";
	public static final String msgListarProfesorError = "Error al listar los profesores";

	// Nivel
	public static final String msgListarNivelOk = "Niveles listados correctamente";
	public static final String msgListarNivelError = "Error al listar niveles";

	// Grado
	public static final String msgListarGradoOk = "Grados listados correctamente";
	public static final String msgListarGradoError = "Error al listar grados";

	// Seccion
	public static final String msgListarSeccionOk = "Seccion listados correctamente";
	public static final String msgListarSeccionError = "Error al listar seccion";

	// Departamento
	public static final String msgListarDepartamentoError = "Error al listar departamentos";
	public static final String msgListarDepartamentoOK = "Departamentos listados correctamente";

	// Provincia
	public static final String msgListarProvinciaError = "Error al listar provincias";
	public static final String msgListarProvinciaOK = "Provincias listados correctamente";

	// Distrito
	public static final String msgListarDistritoError = "Error al listar distritos";
	public static final String msgListarDistritoOK = "Distritos listados correctamente";

	// Tipo Zona
	public static final String msgListarTipoZonaError = "Error al listar tipos de zona";
	public static final String msgListarTipoZonaOK = "Tipos de zona listados correctamente";
	
	//Ambientes
	public static final String msgListarAmbientesOk = "Se listaron los ambientes correctamente";
	public static final String msgListarAmbientesError = "Error al listar los ambientes";
	public static final String msgRegistrarAmbienteOk = "El ambiente se ha registrado correctamente";
	public static final String msgRegistrarAmbienteError = "Error al registrar el ambiente en la base de datos";
	public static final String msgActualizarAmbienteOk = "El ambiente se ha actualizado correctamente";
	public static final String msgActualizarAmbienteError = "Error al actualizar el ambiente en la base de datos";
	
	//TiposAmbiente
	public static final String msgListarTiposAmbientesOk = "Se listaron los tipos de ambiente correctamente";
	public static final String msgListarTiposAmbientesError = "Error al listar los tipos de ambiente";
	public static final String msgRegistrarTipoAmbienteOk = "El tipo de ambiente se ha registrado correctamente";
	public static final String msgRegistrarTipoAmbienteError = "Error al registrar el tipo de ambiente en la base de datos";
	public static final String msgActualizarTipoAmbienteOk = "El tipo de ambiente se ha actualizado correctamente";
	public static final String msgActualizarTipoAmbienteError = "Error al actualizar el tipo de ambiente en la base de datos";
	
	//Rutas
	public static final String rutasImagenAlumno = "src/main/resources/Uploads/Alumnos";
	
	//Fotos
	public static final String errorRegistroFoto = "Error al guardar la foto en la Base de Datos";
	public static final String errorLecturaFoto = "Error al intentar leer la foto";
	public static final String errorCargarFoto = "No se pudo cargar la imagen o no es legible";

}
