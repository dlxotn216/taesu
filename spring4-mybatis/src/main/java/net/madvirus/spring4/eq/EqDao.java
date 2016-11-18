package net.madvirus.spring4.eq;

import java.util.List;

import net.madvirus.spring4.eq.vo.EqForSelect;

public interface EqDao {
	List<EqForSelect> selectEqByEqId(String eq_id);
	List<EqForSelect> selectByGroupId(String group_id);
}
