package demo.project.monitor.logininfor.mapper;

import demo.project.monitor.logininfor.domain.Logininfor;
import org.springframework.stereotype.Repository;

@Repository
public interface LogininforMapper {
    public void insertLogininforLogger(Logininfor logininfor);
}
