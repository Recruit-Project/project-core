package com.kyj.fmk.core.util;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 2025-06-18
 * @author 김용준
 * Restful Api에서 사용하는 공통코드 값 셀렉터
 *
 */
@Component
@RequiredArgsConstructor
public class CmSelector {

    private final RedisTemplate<String,String> redisTemplate;

    /**
     * 기술코드,직무코드,공통코드의 여부 ( rediskey)
     * 실제 코드 ( cmCd)
     * @param redisKey
     * @param cmCd
     * @return cmNm
     */
    public  String getCdName(String redisKey,String cmCd){
        return (String)redisTemplate.opsForHash().get(redisKey, cmCd);

    }

    /**
     * 기술스택코드,직무코드에 한하여 모든코드를 리스트형태로 조회
     * @param redisKey
     * @return
     */
    public List<String> getAllCdList(String redisKey){
        return redisTemplate.opsForList().range(redisKey, 0, -1);
    }
}
