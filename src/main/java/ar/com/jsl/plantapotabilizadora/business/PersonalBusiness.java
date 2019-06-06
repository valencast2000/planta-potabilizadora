package ar.com.jsl.plantapotabilizadora.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.jsl.plantapotabilizadora.model.Personal;
import ar.com.jsl.plantapotabilizadora.model.persistence.PersonalRepository;

@Service
public class PersonalBusiness implements IPersonalBusiness {
	
	@Autowired
	private PersonalRepository personalDAO;

	@Override
	public Personal load(long id) throws BusinessException, NotFoundException {
		Optional<Personal> o;
		try {
			o = personalDAO.findById(id);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
		if (o.isPresent())
			return o.get();
		else
			throw new NotFoundException();
	}

	@Override
	public Personal add(Personal personal) throws BusinessException {
		try {
			return personalDAO.save(personal);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public void delete(long id) throws BusinessException {
		try {
			personalDAO.deleteById(id);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public Personal update(Personal personal) throws BusinessException {
		try {
			return personalDAO.save(personal);
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

	@Override
	public List<Personal> list() throws BusinessException {
		try {
			return personalDAO.findAll();
		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

}
