package net.madvirus.spring4.eqgroup;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import net.madvirus.spring4.eqgroup.vo.EqGroupForSelect;

@Service
public class EqGroupService {
	@Autowired
	private EqGroupDao eqgroupDao;
	
	Logger log = LoggerFactory.getLogger(EqGroupController.class);
	
	public List<EqGroupForSelect> selectAll(){
		List<EqGroupForSelect> groups =  eqgroupDao.selectAll();
		
		return groups;
	}
	
	public List<EqGroupForSelect> getGroupParent(Long group_id){
		List<EqGroupForSelect> groups 	=  eqgroupDao.selectAll();
		List<EqGroupForSelect> results 	=  new ArrayList<EqGroupForSelect>();
		Long target_group_id 			=  group_id;		
		Long start 						=  System.currentTimeMillis();
		
		do{	//group_id와 list의 index가 일치함이 보장되어야 함.
			EqGroupForSelect target = groups.get(target_group_id.intValue());
			results.add(target);
			
			target_group_id = target.getUpper_group_id();
			log.info("algorithm test : "+target_group_id);
		}while(target_group_id > 0);
		
//		target_group_id = group_id;	//init
//		do{
//			results.add(groups.get(target_group_id.intValue()));
//			//log.info("pareng group_id : "+target_group_id);
//			for(EqGroupForSelect eqGroup : groups){
//				if(eqGroup.getGroup_id().equals(target_group_id)){
//					target_group_id = eqGroup.getUpper_group_id();
//				}
//			}
//		}while(target_group_id > 0);
		Long end = System.currentTimeMillis();
		
		log.info("duration : " + ((double)(end-start))/3600);
		return results;		
	}
}
