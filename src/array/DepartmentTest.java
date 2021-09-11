package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class DepartmentTest {

	public static void main(String[] args) {

		List<Department> allDepartment = new ArrayList<>();
		Department dep1 = new Department(1, 0, "北京总部");
		Department dep3 = new Department(3, 1, "研发中心");
		Department dep4 = new Department(4, 3, "后端研发组");
		Department dep5 = new Department(5, 3, "后端研发组");
		Department dep6 = new Department(6, 4, "后端实习生组");
		Department dep7 = new Department(7, 3, "前端研发组");
		Department dep8 = new Department(8, 1, "产品部");
		Department dep9 = new Department(9, 5, "产品部");
		Department dep10 = new Department(10, 9, "产品部-sub");
		allDepartment.add(dep9);
		allDepartment.add(dep3);
		allDepartment.add(dep1);
		allDepartment.add(dep7);
		allDepartment.add(dep6);
		allDepartment.add(dep4);
		allDepartment.add(dep8);
		allDepartment.add(dep10);
		allDepartment.add(dep5);

		List<Department> subDepartments = DepartmentTest.getSub(3, allDepartment);

		for (Department subDepartment : subDepartments) {
			System.out.println(subDepartment);
		}
	}

	/**
	 * 根据id，获取所有子部门列表
	 * 
	 * @param id
	 * @return
	 */
	public static List<Department> getSub(int id, List<Department> allDepartments) {
		Map<Integer, List<Department>> parentId2Dep = allDepartments.stream().collect(Collectors.groupingBy(data->data.getPid()));
		List<Department> res=new ArrayList<>();
		getIDs(res, parentId2Dep, id);
		return res;
		
		// 下面这种也行的
//		Set<Integer> idSet = new HashSet<>(10);
//		getSubIDs(idSet, allDepartments, id);
//		return allDepartments.stream().filter((data -> idSet.contains(data.getId()))).collect(Collectors.toList());

	}

	private static void getIDs(List<Department> res, Map<Integer, List<Department>> parentId2Dep, int id) {
		List<Department> c = parentId2Dep.get(id);
		if (c == null) {
			return;
		}
		res.addAll(c);
		Set<Integer> collect = c.stream().map(Department::getId).collect(Collectors.toSet());
		collect.forEach(subId -> getIDs(res, parentId2Dep, subId));
	}

	private static void getSubIDs(Set<Integer> ids, List<Department> allDepartments, int id) {
		Set<Integer> subIds = allDepartments.stream()
				.filter(data -> data.getPid() == id)
				.map(data -> data.getId())
				.collect(Collectors.toSet());
		if (subIds.size() == 0) {
			return;
		}
		ids.addAll(subIds);
		subIds.forEach(subId -> getSubIDs(ids, allDepartments, subId));
	}
}

class Department {

	/** id */
	private int id;

	/** parent id */
	private int pid;

	/** 名称 */
	private String name;

	public Department(int id, int pid, String name) {
		this.id = id;
		this.pid = pid;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Department{" + "id=" + id + ", pid=" + pid + ", name='" + name + '\'' + '}';
	}
}
