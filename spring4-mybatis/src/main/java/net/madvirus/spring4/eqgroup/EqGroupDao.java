package net.madvirus.spring4.eqgroup;

import java.util.List;

import net.madvirus.spring4.eqgroup.vo.EqGroupForSelect;

public interface EqGroupDao {
	List<EqGroupForSelect> selectAll();
}
