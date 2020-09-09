package com.xq17.snack.mapper;
import java.util.List;

import com.xq17.snack.bean.GoodsType;

/**
 * 
    * @ClassName: IGoodsTypeMapper  
    * @Description: 商品类型管理数据模型层
    * @author xq17  
    * @date 2020年9月2日  
    *
 */


public interface IGoodsTypeMapper {
	public List<GoodsType> finds();

	public List<GoodsType> findAll();
}
