package org.kg.myapp.emp.model.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.kg.myapp.emp.model.vo.EmpVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class EmpRepository implements IEmpRepository {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public class EmpMapper implements RowMapper<EmpVO> {
		@Override
		public EmpVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			EmpVO emp = new EmpVO();
			emp.setEmplyeeId(rs.getInt("employee_id"));
			emp.setFirstName(rs.getString("First_name"));
			emp.setLastName(rs.getString(3));
			emp.setEmail(rs.getString(4));
			emp.setPhoneNumber(rs.getString(5));
			emp.setHireDate(rs.getDate(6));
			emp.setJobId(rs.getString(7));
			emp.setSalary(rs.getDouble(8));
			emp.setCommissionPct(rs.getDouble(9));
			emp.setManagerId(rs.getInt(10));
			emp.setDepartmentId(rs.getInt(11));
			return emp;
		}
	}
									
	RowMapper<EmpVO> empMapper = new RowMapper<EmpVO>() { //익명클래스 생성
		@Override
		public EmpVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			EmpVO emp = new EmpVO();
			emp.setEmplyeeId(rs.getInt("employee_id"));
			emp.setFirstName(rs.getString("First_name"));
			emp.setLastName(rs.getString(3));
			emp.setEmail(rs.getString(4));
			emp.setPhoneNumber(rs.getString(5));
			emp.setHireDate(rs.getDate(6));
			emp.setJobId(rs.getString(7));
			emp.setSalary(rs.getDouble(8));
			emp.setCommissionPct(rs.getDouble(9));
			emp.setManagerId(rs.getInt(10));
			emp.setDepartmentId(rs.getInt(11));
			return emp;
		}
	};
	
	@Override
	public int getEmpCount() {
	String sql = "select count(*) from employees";
	return jdbcTemplate.queryForObject(sql, Integer.class);
	}
	@Override
	public int getEmpCount(int deptId) {	//부서번호	
	String sql = "select count(*) from employees where department_id=?";
	return jdbcTemplate.queryForObject(sql, Integer.class, deptId);
	}

	@Override
	public List<EmpVO> getEmpList() {	// 리스트 가져오기
		String sql = "select * from employees";
		return jdbcTemplate.query(sql, empMapper);
	}
	@Override
	public EmpVO getEmpInfo(int empId) {
		String sql = "select * from employees where employee_id=?";
		return jdbcTemplate.queryForObject(sql, new EmpMapper(), empId);
	}
	@Override
	public void updateEmp(EmpVO emp) {
		String sql = "update employees set first_name=?, last_name=?,"
					+"email=?, phone_number=?, hire_date=?, job_id=?"
					+"department_id=? where employee_id=?";
		jdbcTemplate.update(sql,emp.getFirstName(),emp.getLastName(),
					emp.getEmail(),emp.getPhoneNumber(),emp.getHireDate(),
					emp.getJobId(),emp.getSalary(),emp.getCommissionPct(),
					emp.getManagerId(),emp.getDepartmentId(),emp.getEmployeeId());
	}
	
	@Override
	public void insertEmp(EmpVO emp) {
		String sql = "insert into employees" + "values(?,?,?,?,?,sysdate,?,?,?,?,?)";
		jdbcTemplate.update(sql,emp.getEmployeeId(),
		emp.getFirstName(),emp.getLastName(),emp.getEmail(),
		emp.getPhoneNumber(),emp.getJobId(),emp.getSalary(),
		emp.getCommissionPct(),emp.getManagerId(),emp.getDepartmentId());
	}
	
	@Override
	public void deleteEmp(int empId) {
		String sql = "delete from employees where employee_id?";
		jdbcTemplate.update(sql, empId);
	}
	
	@Override
	public void deleteJobHistory(int empId) {
		String sql = "delete from job_history where employee_id=?";
		jdbcTemplate.update(sql, empId);
	}
	
	@Override
	public List<Map<String, Object>> getAllDeptId() {
		String sql = "select deprtment_id as departmentId,"
					+"department_name as departmentName from departments";
		return jdbcTemplate.queryForList(sql);
	}
	@Override
	public List<Map<String, Object>> getAllJobId() {
		String sql = "select job_id as jobId, job_title as jobTitle from jobs";
		return jdbcTemplate.queryForList(sql);
	}
	@Override
	public List<Map<String, Object>> getAllManagerId() {
		String sql = "select employee_id as managerId,"
					+"first_name||' '||last_name as managerName "
					+"from employees "
					+"where employee_id in "
					+"(select distinct manager_id from employees)";
		return jdbcTemplate.queryForList(sql);
	}
	@Override
	public List<EmpVO> getSearchList(String name) {
		String sql = "select * from employees where first_name like ? or last_name like ?";
		return jdbcTemplate.query(sql, empMapper, name, name);
	}
	
	



	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}