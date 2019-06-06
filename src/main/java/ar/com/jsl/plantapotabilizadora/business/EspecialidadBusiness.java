package ar.com.jsl.plantapotabilizadora.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import ar.com.jsl.plantapotabilizadora.model.Especialidad;
import ar.com.jsl.plantapotabilizadora.model.Personal;
import ar.com.jsl.plantapotabilizadora.model.persistence.EspecialidadRepository;

public class EspecialidadBusiness implements IEspecialidadBusiness {
	
	@Autowired
	private EspecialidadRepository especialidadDAO;


	@Override
	public Especialidad load(long id) throws BusinessException, NotFoundException {
		Optional<Especialidad> o;
		try {
			o = especialidadDAO.findById(id);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
		if (o.isPresent())
			return o.get();
		else
			throw new NotFoundException();
	}

	@Override
	public Especialidad add(Especialidad especialidad) throws BusinessException {
		try {
			return especialidadDAO.save(especialidad);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public void delete(long id) throws BusinessException {
		try {
			especialidadDAO.deleteById(id);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public Especialidad update(Especialidad especialidad) throws BusinessException {
		try {
			return especialidadDAO.save(especialidad);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public List<Especialidad> list() throws BusinessException {
		try {
			return especialidadDAO.findAll();
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

}
