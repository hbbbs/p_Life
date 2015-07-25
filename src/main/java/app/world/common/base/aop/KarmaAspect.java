package app.world.common.base.aop;

import app.world.common.base.model.interfaces.IKarma;
import app.world.common.base.model.karma.Karma;
import app.world.common.base.model.karma.KarmaAll;
import app.world.common.base.model.karma.KarmaEffection;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Arrays;

/**
 * Created by HB on 2015/7/1.
 */
@Aspect
public class KarmaAspect {

    @Before("execution(* app.world..domain..*.$add*(..))")
    public void beforeRunning(JoinPoint point){
        System.out.println("@Before：模拟日志记录功能...");
        System.out.println("@Before：目标方法为："  + point.getSignature().getName());
        System.out.println("@Before：参数为：" +
                Arrays.toString(point.getArgs()));
        System.out.println("@Before：被织入的目标对象为：" + point.getTarget());

        String methodName = point.getSignature().getName();
        String fieldName = methodName.substring(methodName.lastIndexOf("_")+1);     //最后一个"_"后面的是fieldName

        Object[] args = point.getArgs();
        if(args != null && args[0] != null && args[0] instanceof Karma && args[1] != null && args[1] instanceof Integer){
            if(point.getTarget() != null && point.getTarget() instanceof IKarma){
                IKarma target = (IKarma)(point.getTarget());
                Karma karma = (Karma)args[0];
                Integer effection = (Integer)args[1];
                KarmaAll ka = target.getKarmaEffection().get(karma.hashCode());
                if(ka != null){
                    //@todo: 加入还原处理
                }

                KarmaEffection newKe = new KarmaEffection();
                newKe.setFieldName(fieldName);
                newKe.setEffection(effection);
                KarmaAll newKa = new KarmaAll();
                newKa.setKarma(karma);
                newKa.setKe(newKe);
                target.getKarmaEffection().put(karma.hashCode(), newKa);

            }
        }
        System.out.println(point.getTarget());
    }
}
