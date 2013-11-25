package io.vertx.lang.php;

import com.caucho.quercus.Location;
import com.caucho.quercus.QuercusException;
import com.caucho.quercus.env.Callable;
import com.caucho.quercus.env.Env;
import org.vertx.java.core.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: leng
 * Date: 11/16/13
 * Time: 1:14 AM
 * To change this template use File | Settings | File Templates.
 */
public class PhpVerticleFactory2 extends PhpVerticleFactory {

  public static Callable exceptionHandler;

  /**
   * Reports an exception in the verticle.
   */
  @Override
  public void reportException(Logger logger, Throwable t) {
    // A Quercus language exception.
    if (t instanceof QuercusException) {
      Env env = Env.getCurrent();
      Location location = env.getLocation();

      logger.error("\nAn exception occured in a PHP verticle.");

      // TODO: This stack trace should show only PHP related called, not
      // Java calls. Currently it only shows the trace of Java code execution.
      // logger.error(env.getStackTraceAsString(t, env.getLocation()) + "\n");
      String className = location.getClassName();
      String funcName = location.getFunctionName();

      if (funcName != null && funcName != "NULL" && !funcName.startsWith("__quercus_")) {
        if (className != "NULL" && funcName != "NULL" && !funcName.startsWith("__quercus_")) {
          String msg = String.format("%s in %s on line %d in %s::%s()", t.getMessage(), location.getFileName(), location.getLineNumber(), className, funcName);
          logger.error(msg);

          if(exceptionHandler!=null) {
            logger.error("Passing exception to PHP exception handler");
            exceptionHandler.call(env, env.wrapJava(msg), env.wrapJava(location.getFileName()), env.wrapJava(location.getLineNumber()), env.wrapJava(className), env.wrapJava(funcName));
          }
        }
        else {
          String msg = String.format("%s in %s on line %d in %s()", t.getMessage(), location.getFileName(), location.getLineNumber(), funcName);
          logger.error(msg);

          if(exceptionHandler!=null) {
            logger.error("Passing exception to PHP exception handler");
            exceptionHandler.call(env, env.wrapJava(msg), env.wrapJava(location.getFileName()), env.wrapJava(location.getLineNumber()), env.wrapJava(""), env.wrapJava(funcName));
          }
        }
      }
      else {
        String msg = String.format("%s in %s on line %d", t.getMessage(), location.getFileName(), location.getLineNumber());
        logger.error(msg);

        if(exceptionHandler!=null) {
          logger.error("Passing exception to PHP exception handler");
          exceptionHandler.call(env, env.wrapJava(msg), env.wrapJava(location.getFileName()), env.wrapJava(location.getLineNumber()), env.wrapJava(""), env.wrapJava(""));
        }
      }
//      env.call(env.wrapJava("setExceptionHandler").toStringValue(), env.wrapJava(t));
    }
    else {
      Env env = Env.getCurrent();
      Location location = env.getLocation();

      logger.info(t.toString());

      if(t.toString() == "java.lang.NullPointerException" && location.getClassName()!=null && location.getFunctionName()!=null){
        String msg = String.format("%s in %s on line %d in %s::%s()", t.getMessage(), location.getFileName(), location.getLineNumber(), location.getClassName(), location.getFunctionName());
        logger.info(msg);
        exceptionHandler.call(env, env.wrapJava(t.toString()), env.wrapJava(location.getFileName()), env.wrapJava(location.getLineNumber()), env.wrapJava(location.getClassName()), env.wrapJava(location.getFunctionName()));
        return;
      }

      t.printStackTrace();

      String msg = String.format("%s",t.toString());

      if(exceptionHandler!=null) {
        logger.error("Passing Global exception to PHP exception handler");
        exceptionHandler.call(env, env.wrapJava(msg), env.wrapJava(""), env.wrapJava(""), env.wrapJava("Global"), env.wrapJava("Global"));
      }

    }
  }
}