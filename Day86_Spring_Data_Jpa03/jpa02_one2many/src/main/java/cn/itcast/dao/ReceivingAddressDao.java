package cn.itcast.dao;

import cn.itcast.pojo.ReceivingAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author NiYueYeee
 * @create 2019-06-03 21:26
 */
public interface ReceivingAddressDao extends JpaRepository<ReceivingAddress, Integer>, JpaSpecificationExecutor<ReceivingAddress> {
}
