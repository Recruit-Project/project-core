package com.kyj.fmk.core.service.cmcd;

import com.kyj.fmk.core.model.CmCdConst;
import com.kyj.fmk.core.model.cmcd.req.ReqCommonCdDTO;
import com.kyj.fmk.core.model.cmcd.res.ResCommonCdDTO;
import com.kyj.fmk.core.redis.RedisKey;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 2025-08-111
 * @author 김용준
 * Restful Api에서 사용하는 공통코드에 대한 레디스조회를 위한 서비스다
 *
 */
@Service
@RequiredArgsConstructor
public class CmCdRedisServiceImpl implements CmCdRedisService{

    private final RedisTemplate<String,String> redisTemplate;
    /**
     * 공통코드를 레디스에서 조회하는 서비스
     * @param reqCommonCdDTO
     * @return
     */
    @Override
    public  Map<String, String> selectRedisCmCdList(ReqCommonCdDTO reqCommonCdDTO) {

        HashOperations<String, String, String> hashOps = redisTemplate.opsForHash();
        Map<String, String> grpStCdMap =  null;

//        String redisKey = null;

        if(reqCommonCdDTO.getCmCd().equals(CmCdConst.TEAM_STY_CD)){
            grpStCdMap = hashOps.entries(RedisKey.CM_TEAM_STY_CD);
//            redisKey = RedisKey.CM_TEAM_STY_CD;

        } else if (reqCommonCdDTO.getCmCd().equals(CmCdConst.MT_STY_CD)) {
            grpStCdMap = hashOps.entries(RedisKey.CM_MT_STY_CD);
//            redisKey = RedisKey.CM_MT_STY_CD;

        } else if (reqCommonCdDTO.getCmCd().equals(CmCdConst.RECRUIT_ST_CD)) {
            grpStCdMap = hashOps.entries(RedisKey.CM_RECRUIT_ST_CD);
//            redisKey = RedisKey.CM_RECRUIT_ST_CD;

        } else if (reqCommonCdDTO.getCmCd().equals(CmCdConst.GRP_ST_CD)) {
            grpStCdMap = hashOps.entries(RedisKey.CM_GRP_ST_CD);
//            redisKey = RedisKey.CM_GRP_ST_CD;

        } else if (reqCommonCdDTO.getCmCd().equals(CmCdConst.CMC_TONE_CD)) {
            grpStCdMap = hashOps.entries(RedisKey.CM_CMC_TONE_CD);
//            redisKey = RedisKey.CM_CMC_TONE_CD;

        } else if (reqCommonCdDTO.getCmCd().equals(CmCdConst.APY_ST_CD)) {
            grpStCdMap = hashOps.entries(RedisKey.CM_APY_ST_CD);
//            redisKey = RedisKey.CM_APY_ST_CD;

        }


//        List<String> keys = new ArrayList<>(grpStCdMap.keySet());
//
//        //코드 이름 매핑
//        ResCommonCdDTO resCommonCdDTO = new ResCommonCdDTO();

//        for(String key: keys){
//            //매핑 및 리스트 추가
//            String cdNm= cmSelector.getCdName(redisKey,key);
//            resCommonCdDTO.setCmCd(reqCommonCdDTO.getCmCd());
//            resCommonCdDTO.setCmCdVal(key);
//            resCommonCdDTO.setCmCdValNm(cdNm);
//            list.add(resCommonCdDTO);
//        }
        return grpStCdMap;
    }
}
