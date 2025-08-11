package com.kyj.fmk.core.service.cmcd;

import com.kyj.fmk.core.model.cmcd.req.ReqCommonCdDTO;
import com.kyj.fmk.core.model.cmcd.res.ResCommonCdDTO;

import java.util.List;

/**
 * 2025-08-111
 * @author 김용준
 * Restful Api에서 사용하는 공통코드에 대한 레디스조회를 위한 서비스다
 *
 */
public interface CmCdRedisService {

    public List<ResCommonCdDTO> selectRedisCmCdList(ReqCommonCdDTO reqCommonCdDTO);
}
