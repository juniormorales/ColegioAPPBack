package company.app.colegioBack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import company.app.colegioBack.dto.ResponseWrapper;
import company.app.colegioBack.models.Perfil;
import company.app.colegioBack.service.ModuloService;
import company.app.colegioBack.util.Constantes;




@RestController
@RequestMapping("/api/modulo")
public class ModuloController {

	@Autowired
	private ModuloService service;	
	
	@PostMapping
	public ResponseWrapper listar(@RequestBody Perfil perfil) throws Exception {
		try {
			ResponseWrapper response = new ResponseWrapper();
			List res_modulo = service.listarModuloPorPerfil(perfil);
			if (res_modulo != null) {
				response.setEstado(Constantes.valTransaccionOk);
				response.setMsg(Constantes.msgListarXPerfilModuloOk);
				response.setAaData(res_modulo);
				return response;
			} else {
				System.out.println(this.getClass().getSimpleName() + " Error al listar Modulos.");
				throw new Exception(Constantes.msgListarXPerfilModuloError);
			}
		} catch (Exception e) {
			System.out.println(this.getClass().getSimpleName() + " listar. ERROR : " + e);
			System.out.println(this.getClass().getSimpleName() + "listar. " + "Linea nro : "
					+ e.getStackTrace()[0].getLineNumber());
			throw new Exception(Constantes.msgListarXPerfilModuloError);
		}
	}
	
}
