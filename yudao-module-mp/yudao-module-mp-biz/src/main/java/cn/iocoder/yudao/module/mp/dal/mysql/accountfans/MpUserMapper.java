package cn.iocoder.yudao.module.mp.dal.mysql.accountfans;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.module.mp.controller.admin.user.vo.MpUserPageReqVO;
import cn.iocoder.yudao.module.mp.dal.dataobject.user.MpUserDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MpUserMapper extends BaseMapperX<MpUserDO> {

    default PageResult<MpUserDO> selectPage(MpUserPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<MpUserDO>()
                .likeIfPresent(MpUserDO::getOpenid, reqVO.getOpenid())
                .likeIfPresent(MpUserDO::getNickname, reqVO.getNickname())
                .eqIfPresent(MpUserDO::getAccountId, reqVO.getAccountId())
                .orderByDesc(MpUserDO::getId));
    }

}