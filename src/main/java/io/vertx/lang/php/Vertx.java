/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the MIT License (the "License"); you may not use this
 * file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 *     http://opensource.org/licenses/MIT
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.vertx.lang.php;

import com.caucho.quercus.env.*;
import io.vertx.lang.php.eventbus.EventBus;
import io.vertx.lang.php.file.FileSystem;
import io.vertx.lang.php.http.HttpClient;
import io.vertx.lang.php.http.HttpServer;
import io.vertx.lang.php.net.NetClient;
import io.vertx.lang.php.net.NetServer;
import io.vertx.lang.php.shareddata.SharedData;
import io.vertx.lang.php.sockjs.SockJSServer;
import io.vertx.lang.php.util.HandlerFactory;
import io.vertx.lang.php.util.PhpTypes;

import java.util.Map;

import org.vertx.java.core.logging.Logger;

import com.caucho.quercus.annotation.Optional;

/**
 * A static Vertx instance access class.
 * 
 * This is a PHP compatible class that acts as the primary interface for
 * interacting with the Vert.x core API within PHP.
 * 
 * @author Jordan Halterman
 */
public final class Vertx {

  /**
   * Creates a TCP/SSL server.
   */
  public static NetServer createNetServer(Env env) {
    return new NetServer(PhpVerticleFactory.vertx.createNetServer());
  }

  /**
   * Creates a TCP/SSL client.
   */
  public static NetClient createNetClient(Env env) {
    return new NetClient(PhpVerticleFactory.vertx.createNetClient());
  }

  /**
   * Creates an HTTP/HTTPS server.
   */
  public static HttpServer createHttpServer(Env env) {
    return new HttpServer(PhpVerticleFactory.vertx.createHttpServer());
  }

  /**
   * Creates an HTTP/HTTPS client.
   */
  public static HttpClient createHttpClient(Env env) {
    return new HttpClient(PhpVerticleFactory.vertx.createHttpClient());
  }

  /**
   * Creates a SockJS server.
   */
  public static SockJSServer createSockJSServer(Env env, HttpServer server) {
    return new SockJSServer(PhpVerticleFactory.vertx.createSockJSServer(server.getVertxServer()));
  }

  /**
   * Returns a boolean value indicating whether the current thread is an event
   * loop thread.
   */
  public static BooleanValue isEventLoop(Env env) {
    return BooleanValue.create(PhpVerticleFactory.vertx.isEventLoop());
  }

  /**
   * Returns a boolean value indicating whether the current thread is a worker
   * thread.
   */
  public static BooleanValue isWorker(Env env) {
    return BooleanValue.create(PhpVerticleFactory.vertx.isWorker());
  }

  /**
   * Returns the Vert.x event bus.
   */
  public static EventBus eventBus(Env env) {
    return new EventBus(PhpVerticleFactory.vertx.eventBus());
  }

  /**
   * Returns the Vertx FileSystem instance.
   */
  public static FileSystem fileSystem(Env env) {
    return new FileSystem(PhpVerticleFactory.vertx.fileSystem());
  }

  /**
   * Returns the Vertx SharedData instance.
   */
  public static SharedData sharedData(Env env) {
    return new SharedData(PhpVerticleFactory.vertx.sharedData());
  }

  /**
   * Returns the current Vertx context.
   */
  public static Context currentContext(Env env) {
    return new Context(PhpVerticleFactory.vertx.currentContext());
  }

  /**
   * Put the handler on the event queue for the current loop (or worker context)
   * so it will be run asynchronously ASAP after this event has been processed
   * 
   * @param callback
   *          A callable PHP function, method, or closure.
   */
  public static void runOnContext(Env env, Value handler) {
    currentContext(env).runOnContext(env, handler);
  }

  /**
   * Sets a timed handler.
   */
  public static LongValue setTimer(Env env, LongValue delay, Value handler) {
    PhpTypes.assertCallable(env, handler, "Handler argument to Vertx::runOnContext() must be callable.");
    long timerId = PhpVerticleFactory.vertx.setTimer(delay.toLong(), HandlerFactory.<Long>createGenericHandler(env, handler));
    LongValue timerIdLongVal = new LongValue(timerId);
    return timerIdLongVal;
  }

  /**
   * Sets a periodic handler.
   */
  public static LongValue setPeriodic(Env env, LongValue delay, Value handler) {
    PhpTypes.assertCallable(env, handler, "Handler argument to Vertx::runOnContext() must be callable.");
    long timerId = PhpVerticleFactory.vertx.setPeriodic(delay.toLong(), HandlerFactory.<Long>createGenericHandler(env, handler));
    LongValue timerIdLongVal = new LongValue(timerId);
    return timerIdLongVal;
  }

  /**
   * Cancels the timer with the specified id.
   * 
   * @param id
   *          The timer id.
   * @return A value indicating whether the timer was successfully cancelled.
   */
  public static BooleanValue cancelTimer(Env env, LongValue id) {
    boolean result = PhpVerticleFactory.vertx.cancelTimer(id.toLong());
    return BooleanValue.create(result);
  }

  /**
   * Stops the eventbus and any resources managed by the eventbus.
   */
  public static void stop(Env env) {
    PhpVerticleFactory.vertx.stop();
  }

  /**
   * Deploys a module. AsyncResultHandler<Void>
   */
  public static void deployModule(Env env, StringValue moduleName, @Optional ArrayValue config,
      @Optional("1") NumberValue instances, @Optional Value handler) {
    boolean hasConfig = PhpTypes.notNull(config);
    boolean hasHandler = PhpTypes.notNull(handler);
    if (hasConfig && hasHandler) {
      PhpTypes.assertCallable(env, handler, "Handler argument to Vertx::deployModule() must be callable.");
      PhpVerticleFactory.container.deployModule(moduleName.toString(),
          PhpTypes.arrayToJson(env, config), instances.toInt(),
          HandlerFactory.<String>createAsyncGenericHandler(env, handler));
    }
    else if (hasConfig) {
      PhpVerticleFactory.container.deployModule(moduleName.toString(),
          PhpTypes.arrayToJson(env, config), instances.toInt());
    }
    else if (hasHandler) {
      PhpTypes.assertCallable(env, handler, "Handler argument to Vertx::deployModule() must be callable.");
      PhpVerticleFactory.container.deployModule(moduleName.toString(), instances.toInt(),
          HandlerFactory.<String>createAsyncGenericHandler(env, handler));
    }
    else {
      PhpVerticleFactory.container.deployModule(moduleName.toString(), instances.toInt());
    }
  }

  /**
   * Undeploys a module.
   */
  public static void undeployModule(Env env, StringValue deploymentID, @Optional Value handler) {
    if (PhpTypes.notNull(handler)) {
      PhpTypes.assertCallable(env, handler, "Handler argument to Vertx::undeployModule() must be callable.");
      PhpVerticleFactory.container.undeployModule(deploymentID.toString(),
          HandlerFactory.createAsyncVoidHandler(env, handler));
    }
    else {
      PhpVerticleFactory.container.undeployModule(deploymentID.toString());
    }
  }

  /**
   * Deploys a verticle.
   */
  public static void deployVerticle(Env env, StringValue main, @Optional ArrayValue config,
      @Optional("1") NumberValue instances, @Optional Value handler) {
    boolean hasConfig = PhpTypes.notNull(config);
    boolean hasHandler = PhpTypes.notNull(handler);
    if (hasConfig && hasHandler) {
      PhpTypes.assertCallable(env, handler, "Handler argument to Vertx::deployVerticle() must be callable.");
      PhpVerticleFactory.container.deployVerticle(main.toString(),
          PhpTypes.arrayToJson(env, config), instances.toInt(),
          HandlerFactory.<String>createAsyncGenericHandler(env, handler));
    }
    else if (hasConfig) {
      PhpVerticleFactory.container.deployVerticle(main.toString(),
          PhpTypes.arrayToJson(env, config), instances.toInt());
    }
    else if (hasHandler) {
      PhpTypes.assertCallable(env, handler, "Handler argument to Vertx::deployVerticle() must be callable.");
      PhpVerticleFactory.container.deployVerticle(main.toString(), instances.toInt(),
          HandlerFactory.<String>createAsyncGenericHandler(env, handler));
    }
    else {
      PhpVerticleFactory.container.deployVerticle(main.toString(), instances.toInt());
    }
  }

  /**
   * Undeploys a verticle.
   */
  public static void undeployVerticle(Env env, StringValue deploymentID, @Optional Value handler) {
    if (PhpTypes.notNull(handler)) {
      PhpTypes.assertCallable(env, handler, "Handler argument to Vertx::undeployVerticle() must be callable.");
      PhpVerticleFactory.container.undeployVerticle(deploymentID.toString(), HandlerFactory.createAsyncVoidHandler(env, handler));
    }
    else {
      PhpVerticleFactory.container.undeployVerticle(deploymentID.toString());
    }
  }

  /**
   * Deploys a verticle.
   */
  public static void deployWorkerVerticle(Env env, StringValue main, @Optional ArrayValue config,
      @Optional("1") NumberValue instances) {
    boolean hasConfig = config != null && !config.isDefault();
    if (hasConfig) {
      PhpVerticleFactory.container.deployWorkerVerticle(main.toString(),
          PhpTypes.arrayToJson(env, config), instances.toInt());
    }
    else {
      PhpVerticleFactory.container.deployWorkerVerticle(main.toString(), instances.toInt());
    }
  }

  /**
   * Returns the current Vertx container environment.
   */
  public static ArrayValue env(Env env) {
    Map<String, String> map = PhpVerticleFactory.container.env();
    ArrayValue array = new ArrayValueImpl();
    for (Map.Entry<String, String> entry : map.entrySet()) {
      array.append(env.createString(entry.getKey()), env.createString(entry.getValue()));
    }
    return array;
  }

  /**
   * Exits the container.
   */
  public static void exit() {
    PhpVerticleFactory.container.exit();
  }

  /**
   * Returns the Vertx logger.
   */
  public static Logger logger() {
    return PhpVerticleFactory.container.logger();
  }


  /**
   * Set PHP exception handler function
   */
  public static void exceptionHandler(Env env, Callable handler) {
    PhpVerticleFactory2.exceptionHandler = handler;
  }

  /**
   * Set PHP exception handler function
   */
  public static Callable exceptionHandler(Env env) {
    return PhpVerticleFactory2.exceptionHandler;
  }

    /**
   * Returns the Vertx configuration.
   */
  public static ArrayValue config(Env env) {
    return PhpTypes.arrayFromJson(env, PhpVerticleFactory.container.config());
  }

  public String toString() {
    return "php:Vertx";
  }

}
