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
package io.vertx.lang.php.net;

import io.vertx.lang.php.Gettable;
import io.vertx.lang.php.buffer.Buffer;
import io.vertx.lang.php.streams.ExceptionSupport;
import io.vertx.lang.php.streams.ReadStream;
import io.vertx.lang.php.streams.WriteStream;
import io.vertx.lang.php.util.HandlerFactory;
import io.vertx.lang.php.util.PhpTypes;

import com.caucho.quercus.env.BooleanValue;
import com.caucho.quercus.env.Env;
import com.caucho.quercus.env.NumberValue;
import com.caucho.quercus.env.Value;
import com.caucho.quercus.env.StringValue;

/**
 * A PHP compatible implementation of the Vert.x NetSocket.
 *
 * @author Jordan Halterman
 */
public class NetSocket implements ReadStream<NetSocket>, WriteStream<NetSocket>, ExceptionSupport<NetSocket>, Gettable {

  private org.vertx.java.core.net.NetSocket socket;

  public NetSocket(org.vertx.java.core.net.NetSocket socket) {
    this.socket = socket;
  }

  @Override
  public Value __getField(Env env, StringValue name) {
    return env.wrapJava(this).callMethod(env, name);
  }

  /**
   * Returns the local socket address.
   */
  public Value localAddress(Env env) {
    return env.createString(socket.localAddress().toString());
  }

  /**
   * Returns the remote socket address.
   */
  public Value remoteAddress(Env env) {
    return env.createString(socket.remoteAddress().toString());
  }

  /**
   * Sets the socket data handler.
   */
  public NetSocket dataHandler(Env env, Value handler) {
    PhpTypes.assertCallable(env, handler, "Handler argument to Vertx\\Net\\NetSocket::dataHandler() must be callable.");
    socket.dataHandler(HandlerFactory.createBufferHandler(env, handler));
    return this;
  }

  /**
   * Pauses producing on the socket.
   */
  public NetSocket pause(Env env) {
    socket.pause();
    return this;
  }

  /**
   * Resumes producing on the socket.
   */
  public NetSocket resume(Env env) {
    socket.resume();
    return this;
  }

  /**
   * Sets the socket end handler.
   */
  public NetSocket endHandler(Env env, Value handler) {
    PhpTypes.assertCallable(env, handler, "Handler argument to Vertx\\Net\\NetSocket::endHandler() must be callable.");
    socket.endHandler(HandlerFactory.createVoidHandler(env, handler));
    return this;
  }

  /**
   * Sets the socket drain handler.
   */
  public NetSocket drainHandler(Env env, Value handler) {
    PhpTypes.assertCallable(env, handler, "Handler argument to Vertx\\Net\\NetSocket::drainHandler() must be callable.");
    socket.drainHandler(HandlerFactory.createVoidHandler(env, handler));
    return this;
  }

  /**
   * Sets the max write queue size.
   */
  public NetSocket writeQueueMaxSize(Env env, NumberValue value) {
    socket.setWriteQueueMaxSize(value.toInt());
    return this;
  }

  /**
   * Returns true if this NetSocket is encrypted via SSL/TLS.
   */
  public BooleanValue isSsl(Env env) {
    return BooleanValue.create(socket.isSsl());
  }

  /**
   * Indicates whether the write queue is full.
   */
  public BooleanValue writeQueueFull(Env env) {
    return BooleanValue.create(socket.writeQueueFull());
  }

  /**
   * Writes a value to the socket.
   */
  public NetSocket write(Env env, Value data, StringValue enc) {
    if (data.isObject()) {
      socket.write(((Buffer) data.toJavaObject(env, Buffer.class)).__toVertxBuffer());
    }
    else {
      socket.write(data.toString());
    }
    return this;
  }

  /**
   * Sends a file through the socket.
   */
  public NetSocket sendFile(Env env, StringValue filename) {
    return this;
  }

  /**
   * Sets the socket close handler.
   */
  public void closeHandler(Env env, Value handler) {
    PhpTypes.assertCallable(env, handler, "Handler argument to Vertx\\Net\\NetSocket::closeHandler() must be callable.");
    socket.closeHandler(HandlerFactory.createVoidHandler(env, handler));
  }

  /**
   * Closes the socket.
   */
  public void close(Env env) {
    socket.close();
  }

  /**
   * Sets the socket exception handler callback.
   */
  public NetSocket exceptionHandler(Env env, Value handler) {
    PhpTypes.assertCallable(env, handler, "Handler argument to Vertx\\Net\\NetSocket::exceptionHandler() must be callable.");
    socket.exceptionHandler(HandlerFactory.createExceptionHandler(env, handler));
    return this;
  }

  public String toString() {
    return "php:Vertx\\Net\\NetSocket";
  }

}
