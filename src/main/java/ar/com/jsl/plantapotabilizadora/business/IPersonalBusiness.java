package ar.com.jsl.plantapotabilizadora.business;

import java.util.List;

import ar.com.jsl.plantapotabilizadora.model.Personal;

public interface IPersonalBusiness {
	
	public Personal load(long id) throws BusinessException, NotFoundException;

	public Personal add(Personal personal) throws BusinessException;

	public void delete(long id) throws BusinessException;

	public Personal update(Personal personal) throws BusinessException;

	public List<Personal> list() throws BusinessException;
}
