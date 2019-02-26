package demo.project.monitor.logininfor.service;

import demo.project.monitor.logininfor.domain.Logininfor;
import demo.project.monitor.logininfor.mapper.LogininforMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogininforServiceImpl implements ILogininforService{

    @Autowired
    private LogininforMapper logininforMapper;

    @Override
    public void insertLogininforLogger(Logininfor logininfor) {
        logininforMapper.insertLogininforLogger(logininfor);
    }
}
