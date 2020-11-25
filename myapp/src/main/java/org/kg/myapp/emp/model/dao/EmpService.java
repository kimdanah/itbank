package org.kg.myapp.emp.model.dao;

import java.util.List;
import java.util.Map;

import org.kg.myapp.emp.model.vo.EmpVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpService implements IEmpService {

	@Autowired
	IEmpRepository empRepository;
	
	@Override
	public int getEmpCount() {
		return empRepository.getEmpCount();
	}

	@Override
	public int getEmpCount(int deptId) {
		return empRepository.getEmpCount(deptId);
	}

	@Override
	public List<EmpVO> getEmpList() {
		return empRepository.getEmpList();
	}

	@Override
	public EmpVO getEmpInfo(int empId) {
		return empRepository.getEmpInfo(empId);
	}

	@Override
	public void updateEmp(EmpVO emp) {
		empRepository.updateEmp(emp);
	}

	@Override
	public void insertEmp(EmpVO emp) {
		empRepository.updateEmp(emp);
	}

	@Override
	public void deleteEmp(int empId) {
		empRepository.deleteEmp(empId);
	}

	@Override
	public void deleteJobHistory(int empId) {
		empRepository.deleteJobHistory(empId);
	}

	@Override
	public List<Map<String, Object>> getAllDeptId() {
		return empRepository.getAllDeptId();
	}

	@Override
	public List<Map<String, Object>> getAllJobId() {
		return empRepository.getAllJobId();
	}

	@Override
	public List<Map<String, Object>> getAllManagerId() {
		return empRepository.getAllManagerId();
	}

	@Override
	public List<EmpVO> getSearchList(String name) {
		name = "%"+name+"%";
		return empRepository.getSearchList(name);
	}

	

	
}
	
