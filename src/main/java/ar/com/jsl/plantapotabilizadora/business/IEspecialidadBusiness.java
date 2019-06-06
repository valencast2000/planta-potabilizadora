package ar.com.jsl.plantapotabilizadora.business;

import java.util.List;

import ar.com.jsl.plantapotabilizadora.model.Especialidad;

public interface IEspecialidadBusiness {

	public Especialidad load(long id) throws BusinessException, NotFoundException;

	public Especialidad add(Especialidad especialidad) throws BusinessException;

	public void delete(long id) throws BusinessException;

	public Especialidad update(Especialidad especialidad) throws BusinessException;

	public List<Especialidad> list() throws BusinessException;
}
