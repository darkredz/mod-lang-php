# PHP API Manual

1. [Writing Verticles](#writing-verticles)
   * [Verticle clean-up](#verticle-clean-up)
   * [Getting Configuration in a Verticle](#getting-configuration-in-a-verticle)
   * [Logging from a Verticle](#logging-from-a-verticle)
   * [Accessing environment variables from a Verticle](#accessing-environment-variables-from-a-verticle)
   * [Causing the container to exit](#causing-the-container-to-exit)
1. [Deploying and Undeploying Verticles Programmatically](#deploying-and-undeploying-verticles-programmatically)
   * [Deploying a simple verticle](#deploying-a-simple-verticle)
   * [Deploying Worker Verticles](#deploying-worker-verticles)
   * [Deploying a module programmatically](#deploying-a-module-programmatically)
   * [Passing configuration to a verticle programmatically](#passing-configuration-to-a-verticle-programmatically)
   * [Using a Verticle to co-ordinate loading of an application](#using-a-verticle-to-co-ordinate-loading-of-an-application)
   * [Specifying number of instances](#specifying-number-of-instances)
   * [Getting Notified when Deployment is complete](#getting-notified-when-deployment-is-complete)
   * [Undeploying a Verticle](#undeploying-a-verticle)
1. [The Event Bus](#the-event-bus)
   * [The Theory](#the-theory)
      * [Addressing](#addressing)
      * [Handlers](#handlers)
      * [Publish / subscribe messaging](#publish--subscribe-messaging)
      * [Point to point and Request-Response messaging](#point-to-point-messaging)
      * [Transient](#transient)
      * [Types of messages](#types-of-messages)
   * [Event Bus API](#event-bus-api)
      * [Registering and Unregistering Handlers](#registering-and-unregistering-handlers)
      * [Publishing messages](#publishing-messages)
      * [Sending messages](#sending-messages)
      * [Replying to messages](#replying-to-messages)
      * [Message types](#message-types)
   * [Distributed event bus](#distributed-event-bus)
1. [Shared Data](#shared-data)
   * [Shared Maps](#shared-maps)
   * [Shared Sets](#shared-sets)
1. [Buffers](#buffers)
   * [Creating Buffers](#creating-buffers)
   * [Writing to a Buffer](#writing-to-a-buffer)
      * [Appending to a Buffer](#appending-to-a-buffer)
      * [Random access buffer writes](#random-access-buffer-writes)
   * [Reading from a Buffer](#reading-from-a-buffer)
   * [Getting the length of a buffer](#getting-the-length-of-a-buffer)
   * [Other buffer methods](#other-buffer-methods)
1. [Delayed and Periodic Tasks](#delayed-and-periodic-tasks)
   * [One-shot Timers](#one-shot-timers)
   * [Periodic Timers](#periodic-timers)
   * [Cancelling timers](#cancelling-timers)
1. [Writing TCP Servers and Clients](#writing-tcp-servers-and-clients)
   * [Net Server](#net-server)
      * [Creating a Net Server](#creating-a-net-server)
      * [Start the Server Listening](#start-the-server-listening)
      * [Getting Notified of Incoming Connections](#getting-notified-of-incoming-connections)
      * [Closing a Net Server](#closing-a-net-server)
      * [NetServer Properties](#netserver-properties)
      * [Handling Data](#handling-data)
         * [Reading Data from the Socket](#reading-data-from-the-socket)
         * [Writing Data to a Socket](#writing-data-to-a-socket)
      * [Closing a socket](#closing-a-socket)
      * [Close Handler](#close-handler)
      * [Exception handler](#exception-handler)
      * [Read and Write Streams](#read-and-write-streams)
   * [Scaling TCP Servers](#scaling-tcp-servers)
   * [Net Client](#net-client)
      * [Creating a Net Client](#creating-a-net-client)
      * [Making a Connection](#making-a-connection)
      * [Configuring Reconnection](#configuring-reconnection)
      * [NetClient Properties](#netclient-properties)
   * [SSL Servers](#ssl-servers)
   * [SSL Clients](#ssl-clients)
1. [Flow Control - Streams and Pumps](#flow-control---streams-and-pumps)
   * [ReadStream](#readstream)
   * [WriteStream](#writestream)
   * [Pump](#pump)
1. [Writing HTTP Servers and Clients](#writing-http-servers-and-clients)
   * [Writing HTTP servers](#writing-http-servers)
      * [Creating an HTTP Server](#creating-an-http-server)
      * [Start the Server Listening](#start-the-server-listening-1)
      * [Getting Notified of Incoming Requests](#getting-notified-of-incoming-requests)
      * [Handling HTTP Requests](#handling-http-requests)
         * [Request Method](#request-method)
         * [Request URI](#request-uri)
         * [Request Path](#request-path)
         * [Request Query](#request-query)
         * [Request Headers](#request-headers)
         * [Request params](#request-params)
         * [Reading Data from the Request Body](#reading-data-from-the-request-body)
      * [HTTP Server Responses](#http-server-responses)
      * [Setting Status Code and Message](#setting-status-code-and-message)
         * [Writing HTTP responses](#writing-http-responses)
         * [Ending HTTP responses](#ending-http-responses)
         * [Closing the underlying connection](#closing-the-underlying-connection)
         * [Response headers](#response-headers)
         * [Chunked HTTP Responses and Trailers](#chunked-http-responses-and-trailers)
      * [Serving files directly from disk](#serving-files-directly-from-disk)
      * [Pumping Responses](#pumping-responses)
   * [Writing HTTP Clients](#writing-http-clients)
      * [Creating an HTTP Client](#creating-an-http-client)
      * [Pooling and Keep Alive](#pooling-and-keep-alive)
      * [Closing the client](#closing-the-client)
      * [Making Requests](#making-requests)
         * [Writing to the request body](#writing-to-the-request-body)
         * [Ending HTTP requests](#ending-http-requests)
         * [Writing Request Headers](#writing-request-headers)
         * [HTTP chunked requests](#http-chunked-requests)
      * [HTTP Client Responses](#http-client-responses)
         * [Reading Data from the Response Body](#reading-data-from-the-response-body)
      * [100-Continue Handling](#100-continue-handling)
   * [Pumping Requests and Responses](#pumping-requests-and-responses)
   * [HTTPS Servers](#https-servers)
   * [HTTPS Clients](#https-clients)
   * [Scaling HTTP servers](#scaling-http-servers)
1. [Routing HTTP requests with Pattern Matching](#routing-http-requests-with-pattern-matching)
   * [Specifying matches](#specifying-matches)
   * [Extracting parameters from the path](#extracting-parameters-from-the-path)
   * [Extracting params using Regular Expressions](#extracting-params-using-regular-expressions)
   * [Handling requests where nothing matches](#handling-requests-where-nothing-matches)
1. [WebSockets](#websockets)
   * [WebSockets on the server](#websockets-on-the-server)
      * [Reading from and Writing to WebSockets](#reading-from-and-writing-to-websockets)
      * [Rejecting WebSockets](#rejecting-websockets)
   * [WebSockets on the HTTP client](#websockets-on-the-http-client)
   * [WebSockets in the browser](#websockets-in-the-browser)
1. [SockJS](#sockjs)
   * [SockJS Server](#sockjs-server)
   * [Reading and writing data from a SockJS server](#reading-and-writing-data-from-a-sockjs-server)
   * [SockJS client](#sockjs-client)
1. [SockJS - EventBus Bridge](#sockjs---eventbus-bridge)
   * [Setting up the Bridge](#setting-up-the-bridge)
   * [Using the Event Bus from client side JavaScript](#using-the-event-bus-from-client-side-javascript)
   * [Securing the Bridge](#securing-the-bridge)
   * [Messages that require authorization](#messages-that-require-authorization)
1. [File System](#file-system)
   * [Synchronous forms](#synchronous-forms)
   * [copy](#copy)
   * [copyRecursive](#copyrecursive)
   * [move](#move)
   * [truncate](#truncate)
   * [chmod](#chmod)
   * [props](#props)
   * [lprops](#lprops)
   * [link](#link)
   * [symlink](#symlink)
   * [unlink](#unlink)
   * [readSymLink](#readsymlink)
   * [delete](#delete)
   * [deleteRecursive](#deleterecursive)
   * [mkdir](#mkdir)
   * [readDir](#readdir)
   * [readFile](#readfile)
   * [writeFile](#writefile)
   * [createFile](#createfile)
   * [exists](#exists)
   * [fsProps](#fsprops)
   * [open](#open)
   * [AsyncFile](#asyncfile)
      * [Random access writes](#random-access-writes)
      * [Random access reads](#random-access-reads)
      * [Flushing data to underlying storage](#flushing-data-to-underlying-storage)
      * [Using AsyncFile as ReadStream and WriteStream](#using-asyncfile-as-readstream-and-writestream)
      * [Closing an AsyncFile](#closing-an-asyncfile)

<!--
This work is licensed under the Creative Commons Attribution-ShareAlike 3.0 Unported License.
To view a copy of this license, visit http://creativecommons.org/licenses/by-sa/3.0/ or send
a letter to Creative Commons, 444 Castro Street, Suite 900, Mountain View, California, 94041, USA.
-->

# Writing Verticles

We previously discussed how a verticle is the unit of deployment in vert.x.
Let's look in more detail about how to write a verticle.

As an example we'll write a simple TCP echo server. The server just accepts
connections and any data received by it is echoed back on the connection.

Copy the following into a text editor and save it as `server.php`

```php
use Vertx\Pump;

$server = Vertx::createNetServer();

$server->connectHandler(function($socket) {
  $pump = new Pump($socket, $socket);
  $pump->start();
})->listen(1234, 'localhost');
```
    
Now, go to the directory where you saved the file and type

    vertx run server.php
    
The server will now be running. Connect to it using telnet:

    telnet localhost 1234
    
And notice how data you send (and hit enter) is echoed back to you.           

Congratulations! You've written your first verticle.

## Verticle clean-up

TODO

## Getting Configuration in a Verticle

If JSON configuration has been passed when deploying a verticle from either the
command line using `vertx run` or `vertx deploy` and specifying a configuration
file, or when deploying programmatically, that configuration is available to
the verticle through the static `Vertx` class by calling `Vertx::config`.

```php
$config = Vertx::config();

print_r($config);
```

The config returned is an associative array.

## Logging from a Verticle

Each verticle is given its own logger which can also be accessed via the
static `Vertx` class by calling `Vertx::logger`:

```php
$log = Vertx::logger();
$log->info('I am loggin something!');
```

The logger has the functions:

* trace
* debug
* info
* warn
* error
* fatal           

Which have the normal meanings you would expect.

The log files by default go in a file called `vertx.log` in the system temp
directory. On my Linux box this is `/tmp`.

For more information on configuring logging, please see the main manual.

## Accessing environment variables from a Verticle

You can access environment variables from a Verticle from the static `Vertx`
class by calling `Vertx::env`.

```php
$env = Vertx::env();
```

## Causing the container to exit

To exit the container, simply call the static `Vertx::exit` method.

```php
Vertx::exit();
```

# Deploying and Undeploying Verticles Programmatically

You can deploy and undeploy verticles programmatically from inside another
verticle. Any verticles deployed programmatically inherit the path of the
parent verticle. 

## Deploying a simple verticle

* public static void **Vertx::deployVerticle** ( string *$main* [, array *$config = NULL* [, int *$instances = 1* [, callable *$handler = NULL* ]]] )

To deploy a verticle programmatically call the static method `Vertx::deployVerticle`.
The value to the deploy callback is the deployment ID.

To deploy a single instance of a verticle :

```php
Vertx::deployVerticle('my_verticle.php');
```

## Deploying a module programmatically

* public static void **Vertx::deployModule** ( string *$module_name* [, array *$config = NULL* [, int *$instances = 1* [, callable *$handler = NULL* ]]] )

You should use `deployModule` to deploy a module, for example:

```php
Vertx::deployModule('vertx.mailer-v1.0', $config);
```

Would deploy an instance of the `vertx.mailer` module with the specified
configuration. Please see the modules manual for more information about modules.

## Passing configuration to a verticle programmatically   
  
A configuration array can be passed to a verticle that is deployed
programmatically. Inside the deployed verticle the configuration is
accessed with the `Vertx::config` static method. For example:

```php
$config = array(
  'name' => 'foo',
  'age' => 234,
);
Vertx::deployVerticle('my_verticle.php', $config);
```

Then, in `my_verticle.php` you can access the config via `Vertx::config`
as previously explained.

`my_verticle.php`

```php
<?php
$config = Vertx::config();
print_r($config);
```

## Using a Verticle to co-ordinate loading of an application

If you have an application that is composed of multiple verticles that
all need to be started at application start-up, then you can use another
verticle that maintains the application configuration and starts all the
other verticles. You can think of this as your application starter
verticle.

For example, you could create a verticle `app.php` as follows:

```php
$config = array(
  'verticle1config' => array(
    // Config for verticle1
  ),
  'verticle2config' => array(
    // Config for verticle2
  ),
  'verticle3config' => array(
    // Config for verticle3
  ),
  'verticle4config' => array(
    // Config for verticle4
  ),
  'verticle5config' => array(
    // Config for verticle5
  ),
);

// Start the verticles that make up the app.
Vertx::deployVerticle('verticle1.php', $config['verticle1config']);
Vertx::deployVerticle('verticle2.php', $config['verticle2config']);
Vertx::deployVerticle('verticle3.php', $config['verticle3config']);
Vertx::deployVerticle('verticle4.php', $config['verticle4config']);
Vertx::deployVerticle('verticle5.php', $config['verticle5config']);
```

Then you can start your entire application by simply running:

    vertx run app.php

or

    vertx deploy app.php

## Specifying number of instances

By default, when you deploy a verticle, only one instance of the verticle
is deployed. If you want more than one instance to be deployed, e.g. so
you can scale over your cores better, you can specify the number of
instances as follows:

    Vertx::deployVerticle('my_verticle.php', NULL, 10);   
  
The above example would deploy 10 instances.

## Getting Notified when Deployment is complete

The actual verticle deployment is asynchronous and might not complete
until some time after the call to `deployVerticle` has returned. If you
want to be notified when the verticle has completed being deployed, you
can pass a handler as the final argument to `deployVerticle`:

```php
Vertx::deployVerticle('my_verticle.php', NULL, 10, function() use ($log) {
  $log->info("It's been deployed!");
});
```

Note that when using PHP's closures, it's important to remember that you
_must include any external variables in the closure with the `use` keyword_.

## Deploying Worker Verticles

The `vertx::deployVerticle` method deploys standard (non worker) verticles.
If you want to deploy worker verticles use the `Vertx::deployWorkerVerticle`
static method. This method takes the same parameters as `Vertx::deployVerticle`
with the same meanings.

## Undeploying a Verticle

* public static void **Vertx::undeployVerticle** ( string *$deployment_id* [, callable *$handler = NULL* ] )

Any verticles that you deploy programmatically from within a verticle, and
all of their children are automatically undeployed when the parent verticle
is undeployed, so in most cases you will not need to undeploy a verticle
manually, however if you do want to do this, it can be done by calling the
static `Vertx::undeployVerticle` method and passing in the deployment id
that was returned from the call to `Vertx::deployVerticle`

```php
Vertx::deployVerticle('my_verticle.php', NULL, 1, function($deploy_id) {
  Vertx::undeployVerticle($deploy_id);
});
```

# The Event Bus

The event bus is the nervous system of Vert.x.

It allows verticles to communicate with each other irrespective of what
language they are written in, and whether they're in the same vert.x
instance, or in a different vert.x instance. It even allows client side
JavaScript running in a browser to communicate on the same event bus.
(More on that later).

It creates a distributed polyglot overlay network spanning multiple server
nodes and multiple browsers.

The event bus API is incredibly simple. It basically involves registering
handlers, unregistering handlers and sending messages.

First some theory:

## The Theory

### Addressing

Messages are sent on the event bus to an *address*.

Vert.x doesn't bother with any fancy addressing schemes. In vert.x an
address is simply a string, any string is valid. However it is wise to
use some kind of scheme, e.g. using periods to demarcate a namespace.

Some examples of valid addresses are `europe.news.feed1`,
`acme.games.pacman`, `sausages`, and `X`.

### Handlers

A handler is a thing that receives messages from the bus. You register
a handler at an address.

Many different handlers from the same or different verticles can be
registered at the same address. A single handler can be registered
by the verticle at many different addresses.

### Publish / subscribe messaging

The event bus supports *publishing* messages. Messages are published
to an address. Publishing means delivering the message to all handlers
that are registered at that address. This is the familiar
*publish/subscribe* messaging pattern.

### Point to point messaging

The event bus supports *point to point* messaging. Messages are sent
to an address. This means a message is delivered to *at most* one of
the handlers registered at that address. If there is more than one
handler regsitered at the address, one will be chosen using a non-strict
round-robin algorithm.

With point to point messaging, an optional reply handler can be specified
when sending the message. When a message is received by a recipient, and
has been *processed*, the recipient can optionally decide to reply to
the message. If they do so that reply handler will be called.

When the reply is received back at the sender, it too can be replied to.
This can be repeated ad-infinitum, and allows a dialog to be set-up between
two different verticles. This is a common messaging pattern called the
*Request-Response* pattern.

### Transient

*All messages in the event bus are transient, and in case of failure of
all or parts of the event bus, there is a possibility messages will be
lost. If your application cares about lost messages, you should code
your handlers to be idempotent, and your senders to retry after recovery.*

If you want to persist your messages you can use a persistent work queue
module for that.

### Types of messages

Messages that you send on the event bus can be as simple as a string, a
number or a boolean. You can also send vert.x buffers or JSON messages.

It's highly recommended you use JSON messages to communicate between
verticles. JSON is easy to create and parse in all the languages that
vert.x supports.

## Event Bus API

Let's jump into the API

The eventbus is accessible through the static `eventBus` method of the
`Vertx` class.

```php
$eventBus = Vertx::eventBus();
```

### Registering and Unregistering Handlers

* public string **Vertx\EventBus::registerHandler** ( string *$address* , callable *$handler* )

To set a message handler on the address `test.address`, you do the following:

```php
$eventBus = Vertx::eventBus();
$log = Vertx::logger();

$myHandler = function($message) use ($log) {
  $log->info('I received a message '. $message->body);
};

$eventBus->registerHandler('test.address', $myHandler);
```

It's as simple as that. The handler will then receive any messages sent
to that address.

Note that the `$message` object appears to expose members publicly. This
is not actually true. The message body can be accessed using either
`$message->body` or `$message->body()` because internally, PHP's magic
`__get` method is used to call the `body` method. This is a common pattern
used around the Vert.x PHP API.

When you register a handler on an address and you're in a cluster it can
take some time for the knowledge of that new handler to be propagated across
the entire cluster. If you want to be notified when that has completed you
can optionally specify another function to the `registerHandler` function as
the third argument. This function will then be called once the information
has reached all nodes of the cluster. E.g. :

```php
$handler_id = $eventBus->registerHandler('test.address', $myHandler, function() use ($log) {
  $log->info("Yay! I've been propagated across the cluster!");
});
```

### Unregistering handlers

* public void **Vertx\EventBus::unregisterHandler** ( string *$address* , string *$handler_id* )

To unregister a handler it's just as straightforward. You simply call
`unregisterHandler` passing in the address and the handler:

```php
$eventBus->unregisterHandler('test.address', $handler_id);
```

A single handler can be registered multiple times on the same, or different,
addresses so in order to identify it uniquely you have to specify both the
address and the handler. 

As with registering, when you unregister a handler and you're in a cluster it
can also take some time for the knowledge of that unregistration to be propagated
across the entire to cluster. If you want to be notified when that has completed
you can optionally specify another function to the registerHandler as the third
argument. E.g. :

```php
$eventBus->unregisterHandler('test.address', $myHandler, function() use ($log) {
  $log->info("Yay! The handler unregister has been propagated across the cluster!");
});
```

If you want your handler to live for the full lifetime of your verticle there is
no need to unregister it explicitly - Vert.x will automatically unregister any
handlers when the verticle is stopped.    

### Publishing messages

* public void **Vertx\EventBus::publish** ( string *$address* , mixed *$message* )

Publishing a message is also trivially easy. Just publish it specifying the address,
for example:

```php
$eventBus->publish('test.address', 'Hello world!');
```

That message will then be delivered to any handlers registered against the address
`test.address`.

### Sending messages

* public void **Vertx\EventBus::send** ( string *$address* , mixed *$message* [, callable *$reply_handler = NULL* ] )

Sending a message will result in at most one handler registered at the address
receiving the message. This is the point to point messaging pattern.

```php
$eventBus->send('test.address', 'Hello world!');
```

### Replying to messages

* public void **Vertx\EventBus\Message::reply** ( [ mixed *$reply = NULL* ] )

Sometimes after you send a message you want to receive a reply from the recipient.
This is known as the *request-response pattern*.

To do this you send a message, and specify a reply handler as the third argument.
When the receiver receives the message they are passed a replier function as the
second parameter to the handler. When this function is invoked it causes a reply
to be sent back to the sender where the reply handler is invoked. An example will
make this clear:

The receiver:

```php
$log = Vertx::logger();

$myHandler = function($message) use ($log) {
  $log->info('I received a message '. $message->body);

  $message->reply('This is a reply.');
};

$eventBus->registerHandler('test.address', $myHandler);
```

The sender:

```php
$log = Vertx::logger();

$eventBus->send('test.address', 'This is a message', function($reply) use ($log) {
  $log->info('I received a reply '. $reply->body);
});
```

It is legal also to send an empty reply or null reply.

The replies themselves can also be replied to so you can create a dialog between
two different verticles consisting of multiple rounds.

To supply a reply timeout, use the `sendWithTimeout()` method, passing a timeout
in milliseconds as the third arguments.

```php
$log = Vertx::logger();

$eventBus->sendWithTimeout('test.address', 'This is a message', 15000, function($reply, $error) use ($log) {
  if (!$error) {
    $log->info('I received a reply '. $reply->body);
  }
  else {
    $log->info('The send timed out.');
  }
});
```

### Message types

The message you send can be any of the following types:

* number
* string
* boolean
* PHP associative array (this will be converted to a JSON object)
* Vert.x Buffer

Vert.x buffers and JSON objects are copied before delivery if they are delivered
in the same JVM, so different verticles can't access the exact same object instance.

Here are some more examples:

Send some numbers:

```php
$eventBus->send('test.address', 1234);
$eventBus->send('test.address', 3.14159);
```

Send a boolean:

```php
$eventBus->send('test.address', TRUE);
```

Send an associative array:

```php
$array = array(
  'name' => 'Tim',
  'address' => 'The Moon',
  'age' => 457,
);
$eventBus->send('test.address', $array);
```

Null messages can also be sent:

```php
$eventBus->send('test.address', NULL);
```

It's a good convention to have your verticles communicating using associative
arrays (JSON).

## Distributed event bus

To make each vert.x instance on your network participate on the same event bus,
start each vert.x instance with the `-cluster` command line switch.

See the chapter in the main manual on *running vert.x* for more information on
this. 

Once you've done that, any vert.x instances started in cluster mode will merge
to form a distributed event bus.   
      
# Shared Data

* public static Vertx\SharedData **Vertx::sharedData** ( )

Sometimes it makes sense to allow different verticles instances to share data
in a safe way. Vert.x allows simple *Map* and *Set* data structures to be
shared between verticles.

There is a caveat: To prevent issues due to mutable data, vert.x only allows
simple immutable types such as number, boolean and string or Buffer to be used
in shared data. With a Buffer, it is automatically copied when retrieved from
the shared data, so different verticle instances never see the same object
instance.

Currently data can only be shared between verticles in the *same vert.x instance*.
In later versions of vert.x we aim to extend this to allow data to be shared by
all vert.x instances in the cluster.

## The Shared Data object

The PHP API directly exposes the Java API's SharedData object. This object can
be retrieved by calling the static `Vertx::sharedData` method.

```php
$sharedData = Vertx::sharedData();
```

## Shared Maps

* public Vertx\SharedData\Map **Vertx\SharedData::getMap** ( string *$name* )

To use a shared map to share data between verticles first we get a reference to
the map. Shared maps are simply objects that mimic PHP's associative arrays. Note
that they are _not_ actually arrays, but the are instances of a class that
implements the `ArrayAccess` and `Countable` interfaces.

```php
$map = $sharedData->getMap('demo.mymap');
$map['some-key'] = 'some-value';
```

And then, in a different verticle:

```php
$map = $sharedData->getMap('demo.mymap');
Vertx::logger()->info('value of some-key is '. $map['some-key']);
```

## Shared Sets

* public public Vertx\SharedData\Set **Vertx\SharedData::getSet** ( string *$name* )

To use a shared set to share data between verticles first we get a reference
to the set.

```php
$set = $sharedData->getSet('demo.myset');
$set->add('some-value');
```

And then, in a different verticle:

```php
$set = $sharedData->getSet('demo.myset');
```

# Buffers

Most data in vert.x is shuffled around using buffers.

A Buffer represents a sequence of zero or more bytes that can be written to or
read from, and which expands automatically as necessary to accomodate any bytes
written to it. You can perhaps think of a buffer as smart byte array.

## Creating Buffers

Create a buffer from a String. The String will be encoded in the buffer using
UTF-8.

```php
use Vertx\Buffer;

$buff = new Buffer('some-string');
```

## Writing to a Buffer

There are two ways to write to a buffer: appending, and random access. In either
case buffers will always expand automatically to encompass the bytes. It's not
possible to write outside the bounds of the buffer.

### Appending to a Buffer

To append to a buffer, you use the `appendXXX` methods. Append methods exist for
appending other buffers, strings and numbers.

The return value of the `appendXXX` methods is the buffer itself, so these can
be chained:

```php
$buff = new Vertx\Buffer();
$buff->appendInt(123)->appendString('hello');

$socket->write($buff);
```

If you want to append a number as an integer to a buffer you must specify how
you want to encode it in the buffer

```php
$buff->appendByte($number);  // To append the number as 8 bits (signed)

$buff->appendShort($number); // To append the number as 16 bits (signed)

$buff->appendInt($number);   // To append the number as 32 bits (signed)

$buff->appendLong($number);  // To append the number as 64 bits (signed)
```

With floats, you have to specify whether you want to write the number as a 32
bit or 64 bit double precision float

```php
$buff->appendFloat($number);  // To append the number as a 32-bit IEEE 754 floating point number

$buff->appendDouble($number); // To append the number as a 64-bit IEEE 754 double precision floating point number
```

With strings you can specify the encoding, or it will default to UTF-8:

```php
$buff->appendString("hello"); // Write string as UTF-8

$buff->appendString("hello", "UTF-16"); // Write string in specified encoding    
```

Use `appendBuffer` to append another buffer

```php
$buff->appendBuffer($anotherBuffer);    
```

Vert.x PHP also supports a more abstract `append` method, which attempts to
determine the type of data being appended to the buffer and acts accordingly.

```php
$buff->append('foo')->append(1)->append(2.23);
```

Similarly, there are equivalent `get` and `set` methods as well.

```php
$buff->set(0, 'foo')->set(3, 4.55);
```

### Random access buffer writes

You can also write into the buffer at a specific index, by using the `setXXX`
methods. Set methods exist for other buffers, string and numbers. All the set
methods take an index as the first argument - this represents the position in
the buffer where to start writing the data.

The buffer will always expand as necessary to accomodate the data.

```php
$buff = new Vertx\Buffer();

$buff->setInt(1000, 123);
$buff->setBytes(0, "hello");
```

Similarly to the `appendXXX` methods, when you set a number as an integer you
must specify how you want to encode it in the buffer

```php
$buff->setByte($pos, $number);  // To set the number as 8 bits (signed)

$buff->setShort($pos, $number); // To set the number as 16 bits (signed)

$buff->setInt($pos, $number);   // To set the number as 32 bits (signed)

$buff->setLong($pos, $number);  // To set the number as 64 bits (signed)
```

Also with floats, you have to specify whether you want to set the number as a 32
bit or 64 bit double precision float

```php
$buff->setFloat($pos, $number);  // To set the number as a 32-bit IEEE 754 floating point number

$buff->setDouble($pos, $number); // To set the number as a 64-bit IEEE 754 double precision floating point number
```

To set strings use the `setString` methods:

```php
$buff->setString($pos, "hello");           // Write string in default UTF-8 encoding

$buff->setString($pos, "hello", "UTF-16"); // Write the string in the specified encoding     
```

Use `setBuffer` to set another buffer:

```php
$buff->setBuffer($pos, $anotherBuffer);
```

## Reading from a Buffer

Data is read from a buffer using the `getXXX` methods. Get methods exist for
strings and numbers. The first argument to these methods is an index in the
buffer from where to get the data.

```php
$buff = new Vertx\Buffer();

$length = count($buff);
for ($i = 0; $i < $length; $i += 4) {
  Vertx::logger()->info('int value at '. $i .' is '. $buff->getInt($i));
}
```

To read data as integers, you must specify how many bits you want to read:

```php
$num = $buff->getByte($pos);   // Read signed 8 bits

$num = $buff->getShort($pos);  // Read signed 16 bits

$num = $buff->getInt($pos);    // Read signed 32 bits

$num = $buff->getLong($pos);   // Read signed 64 bits  
```

And with floats, you must specify if you want to read the number as a 32 bit
or 64 bit floating point number:

```php
$num = $buff->getFloat($pos);    // Read a 32-bit IEEE 754 floating point number

$num = $buff->getDouble($pos);   // Read as a 64-bit IEEE 754 double precision floating point number 
```

You can read data as strings

```php
$str = $buff->getString($pos, $end); // Read from pos to end interpreted as a string in UTF-8 encoding.    

$str = $buff->getString($pos, $end, 'UTF-16'); // Read from pos to end interpreted as a string in the specified encoding.
```

Or as buffers

```php
$subBuffer = $buff->getBuffer($pos, $end); // Read from pos to end into another buffer    
```

## Getting the length of a buffer

The PHP buffer implements the `Countable` interface. Thus, you can determine
the length of the buffer by using PHP's built-in `count` function.

```php
$length = count($buff);
```

Alternatively, the `length` property also contains the buffer length.

```php
$length = $buff->length;
```

## Other buffer methods:

* `copy()`. Copy the entire buffer

See the JavaDoc for more detailed method level documentation.    


# Delayed and Periodic Tasks

It's very common in vert.x to want to perform an action after a delay, or
periodically.

In standard verticles you can't just make the thread sleep to introduce a
delay, as that will block the event loop thread.

Instead you use vert.x timers. Timers can be *one-shot* or *periodic*. We'll
discuss both

## One-shot Timers

* public static void **Vertx::setTimer** ( int *$delay* , callable *$handler* )

A one shot timer calls an event handler after a certain delay, expressed in
milliseconds. 

To set a timer to fire once you use the static `Vertx::setTimer` method passing in
the delay and the handler

```php
Vertx::setTimer(1000, function() use ($log) {
  $log->info('And one second later this is printed.');
});
```

## Periodic Timers

* public static string **Vertx::setPeriodic** ( int *$interval* , callable *$handler* )

You can also set a timer to fire periodically by using the `setPeriodic`
function. There will be an initial delay equal to the period. The return value
of `setPeriodic` is a unique timer id (number). This can be later used if the
timer needs to be cancelled. The argument passed into the timer event handler
is also the unique timer id:

```php
$id = Vertx::setPeriodic(1000, function($id) use ($log) {
  $log->info('And every second this is printed.');
});

$log->info('First this is printed.');
```

## Cancelling timers

* public static void **Vertx::cancelTimer** ( string *$timer_id* )

To cancel a periodic timer, call the `cancelTimer` function specifying the
timer id. For example:

```php
$id = Vertx::setPeriodic(1000, function($id) use ($log) {
  $log->info('This is not gonna be printed.');
});

Vertx::cancelTimer($id);
```

Or you can cancel it from inside the event handler. The following example cancels
the timer after it has fired 10 times.

```php
$count = 0;

Vertx::setPeriodic(1000, function($id) use ($log) {
  $log->info('In event handler '. $count);
  $count++;
  if ($count == 10) {
    Vertx::cancelTimer($id);
  }
});
```

# Writing TCP Servers and Clients

Creating TCP servers and clients is incredibly easy with vert.x.

## Net Server

### Creating a Net Server

* public static [Vertx\Net\NetServer](#net-server) **Vertx::createNetServer** ( )

To create a TCP server you invoke the static `createNetServer` method on the
`Vertx` class.

```php
$server = Vertx::createNetServer();
```

### Start the Server Listening

* public [Vertx\Net\NetServer](#net-server) **Vertx\Net\NetServer::listen** ( int *$port* [, string *$host = NULL* [, callable *$handler = NULL* ]] )

To tell that server to listen for connections we do:    

```php
$server = Vertx::createNetServer();
$server->listen(1234, 'localhost');
```

The first parameter to `listen` is the port. The second parameter is the hostname
or ip address. If it is omitted or null it will default to `0.0.0.0` which means
it will listen at all available interfaces.


### Getting Notified of Incoming Connections

* public [Vertx\Net\NetServer](#net-server) **Vertx\Net\NetServer::connectHandler** ( callable *$handler* )

Just having a TCP server listening creates a working server that you can connect
to (try it with telnet!), however it's not very useful since it doesn't do anything
with the connections.

To be notified when a connection occurs we need to call the `connectHandler`
function of the server, passing in a handler. The handler will be called when a
connection is made:

```php
$server = Vertx::createNetServer();
$log = Vertx::logger();

$server->connectHandler(function($socket) use ($log) {
  $log->info('A client has connected!');
});

$server->listen(1234, 'localhost');
```

That's a bit more interesting. Now it displays 'A client has connected!' every time a
client connects.   

The return value of the `connectHandler` method is the server itself, so multiple
invocations can be chained together. That means we can rewrite the above as:

```php
$server = Vertx::createNetServer();
$log = Vertx::logger();

$server->connectHandler(function($socket) use ($log) {
  $log->info('A client has connected!');
})->listen(1234, 'localhost');
```

or 

```php
$log = Vertx::logger();

Vertx::createNetServer()->connectHandler(function($socket) use ($log) {
  $log->info('A client has connected!');
})->listen(1234, 'localhost');
```

This is a common pattern throughout the vert.x API.  

### Closing a Net Server

* public void **Vertx\Net\NetServer::close** ( [ callable *$handler = NULL* ] )

To close a net server just call the `close` function.

```php
$server->close();
```

The close is actually asynchronous and might not complete until some time after the
`close` function has returned. If you want to be notified when the actual close has
completed then you can pass in a handler to the `close` function.

This handler will then be called when the close has fully completed.

```php
$server->close(function() use ($log) {
  $log->info('The server is now fully closed.');
});
```

If you want your net server to last the entire lifetime of your verticle, you don't
need to call `close` explicitly, the Vert.x container will automatically close any
servers that you created when the verticle is stopped.    

### NetServer Properties

`Vertx\Net\NetServer` has a set of properties you can set which affect its behaviour.
Firstly there are bunch of properties used to tweak the TCP parameters, in most cases
you won't need to set these:

* `noDelay($tcpNoDelay) // or $server->noDelay = $tcpNoDelay` If `tcpNoDelay` is `TRUE` then
[Nagle's Algorithm](http://en.wikipedia.org/wiki/Nagle's_algorithm) is disabled.
If false then it is enabled.

* `sendBufferSize($size) // or $server->sendBufferSize = $size` Sets the TCP send buffer size in bytes.

* `receiveBufferSize($size) // or $server->receiveBufferSize = $size` Sets the TCP receive buffer size in bytes.

* `keepAlive($keepAlive) // or $server->keepAlive = $keepAlive` if `keepAlive` is true then
[TCP keep alive](http://en.wikipedia.org/wiki/Keepalive#TCP_keepalive) is enabled,
if false it is disabled. 

* `reuseAddress($reuse) // or $server->reuseAddress = $reuse` if `reuse` is true then addresses in TIME_WAIT state can
be reused after they have been closed.

* `soLinger($linger) // or $server->soLinger = $linger`

* `trafficClass($trafficClass) // or $server->trafficClass = $trafficClass`

NetServer has a further set of properties which are used to configure SSL. We'll
discuss those later on.

#### Accessing NetServer properties

The Vert.x PHP API uses PHP's magic methods to allow various objects' properties
to be accessed directly. The `NetServer` object's properties can be accessed
"publicly" via this method.

```php
$size = $server->sendBufferSize;
```

### Handling Data

So far we have seen how to create a NetServer, and accept incoming connections, but
not how to do anything interesting with the connections. Let's remedy that now.

When a connection is made, the connect handler is called passing in an instance of
`NetSocket`. This is a socket-like interface to the actual connection, and allows you
to read and write data as well as do various other things like close the socket.


### Reading Data from the Socket

* public [Vertx\Net\NetSocket](#handling-data) **Vertx\Net\NetSocket::dataHandler** ( callable *$handler* )

To read data from the socket you need to set the `dataHandler` on the socket. This
handler will be called with a `Buffer` every time data is received on the socket.
You could try the following code and telnet to it to send some data:

```php
$server = Vertx::createNetServer();

$server->connectHandler(function($socket) use ($log) {
  $socket->dataHandler(function($buffer) use ($log) {
    $log->info('I received '. count($buffer) .' bytes of data.');
  });
})->listen(1234, 'localhost');
```

### Writing Data to a Socket

* public [Vertx\Net\NetSocket](#handling-data) **Vertx\Net\NetSocket::write** ( [Vertx\Buffer](#buffers) *$buffer* )

To write data to a socket, you invoke the `write` function. This function can be
invoked in a few ways:

With a single buffer:

```php
$myBuffer = new Vertx\Buffer();
$socket->write($myBuffer);
```

A string. In this case the string will encoded using UTF-8 and the result written
to the wire.

```php
$socket->write('Hello world!');
```

A string and an encoding. In this case the string will encoded using the specified
encoding and the result written to the wire.     

```php
$socket->write('Hello world!', 'UTF-16');
```

Let's put it all together.

Here's an example of a simple TCP echo server which simply writes back (echoes)
everything that it receives on the socket:

```php
$log = Vertx::logger();

$server = Vertx::createNetServer();

$server->connectHandler(function($socket) use ($log) {

  $socket->dataHandler(function($buffer) use ($socket) {
    $socket->write($buffer);
  });

})->listen(1234, 'localhost');
```

### Closing a socket

You can close a socket by invoking the `close` method. This will close the
underlying TCP connection.

### Close Handler

* public [Vertx\Net\NetSocket](#handling-data) **Vertx\Net\NetSocket::closeHandler** ( callable *$handler* )

If you want to be notified when a socket is closed, you can set the `closeHandler':

```php
$server = Vertx::createNetServer();

$server->connectHandler(function($socket) use ($log) {

  $socket->closeHandler(function() use ($log) {
    $log->info('The socket is now closed.');
  });

});
```

The closed handler will be called irrespective of whether the close was
initiated by the client or server.

### Exception handler

* public [Vertx\Net\NetSocket](#handling-data) **Vertx\Net\NetSocket::exceptionHandler** ( callable *$handler* )

You can set an exception handler on the socket that will be called if an
exception occurs:

```php
$server = Vertx::createNetServer();

$server->connectHandler(function($socket) use ($log) {

  $socket->exceptionHandler(function() use ($log) {
    $log->error('Oops. Something went wrong.');
  });

});
```

### Read and Write Streams

NetSocket also can at as a `ReadStream` and a `WriteStream`. This allows flow
control to occur on the connection and the connection data to be pumped to and
from other object such as HTTP requests and responses, WebSockets and
asynchronous files.

This will be discussed in depth in the chapter on streams and pumps.

## Scaling TCP Servers

A verticle instance is strictly single threaded.

If you create a simple TCP server and deploy a single instance of it then all
the handlers for that server are always executed on the same event loop (thread).

This means that if you are running on a server with a lot of cores, and you
only have this one instance deployed then you will have at most one core utilised
on your server! That's not very good, right?

To remedy this you can simply deploy more instances of the verticle in the
server, e.g.

    vertx run echo_server.php -instances 20

The above would run 20 instances of `echo_server.php` to a locally running vert.x
instance.

Once you do this you will find the echo server works functionally identically
to before, but, *as if by magic*, all your cores on your server can be utilised
and more work can be handled.

At this point you might be asking yourself *'Hold on, how can you have more than
one server listening on the same host and port? Surely you will get port conflicts
as soon as you try and deploy more than one instance?'*

*Vert.x does a little magic here*.

When you deploy another server on the same host and port as an existing server it
doesn't actually try and create a new server listening on the same host/port.

Instead it internally maintains just a single server, and, as incoming connections
arrive it distributes them in a round-robin fashion to any of the connect handlers
set by the verticles.

Consequently vert.x TCP servers can scale over available cores while each vert.x
verticle instance remains strictly single threaded, and you don't have to do any
special tricks like writing load-balancers in order to scale your server on your
multi-core machine.

## Net Client

A NetClient is used to make TCP connections to servers.

### Creating a Net Client

* public static [Vertx\Net\NetClient](#net-client) **Vertx::createNetClient** ( )

To create a TCP client you invoke the static `createNetClient` method on the
`Vertx` class.

```php
$client = Vertx::createNetClient();
```

### Making a Connection

* public [Vertx\Net\NetClient](#net-client) **Vertx\Net\NetClient::connect** ( int *$port* , string *$host* , callable *$handler* )

To actually connect to a server you invoke the `connect` method:

```php
$client = Vertx::createNetClient();

$client->connect(1234, 'localhost', function($socket) use ($log) {
  $log->info('We have connected.');
});
```

The `connect` method takes the port number as the first parameter, followed by
the hostname or ip address of the server. The third parameter is a connect handler.
This handler will be called when the connection actually occurs.

The argument passed into the connect handler is an instance of `NetSocket`,
exactly the same as what is passed into the server side connect handler. Once
given the `NetSocket` you can read and write data from the socket in exactly the
same way as you do on the server side.

You can also close it, set the closed handler, set the exception handler and use
it as a `ReadStream` or `WriteStream` exactly the same as the server side `NetSocket`.

### Catching exceptions on the Net Client

* public [Vertx\Net\NetClient](#net-client) **Vertx\Net\NetClient::exceptionHandler** ( callable *$handler* )

You can set an exception handler on the `NetClient`. This will catch any exceptions
that occur during connection.

```php
$client = Vertx::createNetClient();

$client->exceptionHandler(function($error) use ($log) {
  $log->info('Cannot connect since the host does not exist!');
});

$client->connect(4242, 'host-that-doesnt-exist', function($socket) use ($log) {
  $log->info("This won't get called.");
});
```

### Configuring Reconnection

* public [Vertx\Net\NetClient](#net-client) **Vertx\Net\NetClient::reconnectAttempts** ( int *$attempts* )
* public [Vertx\Net\NetClient](#net-client) **Vertx\Net\NetClient::reconnectInterval** ( int *$interval* )

A NetClient can be configured to automatically retry connecting or reconnecting to
the server in the event that it cannot connect or has lost its connection. This is
done by invoking the functions `reconnectAttempts` and `reconnectInterval`:

```php
$client = Vertx::createNetClient();

$client->reconnectAttempts(1000);

$client->reconnectInterval(500);
```

Or, alternatively the properties can be set directly:

```php
$client = Vertx::createNetClient();

$client->reconnectAttempts = 1000;

$client->reconnectInterval = 500;
```

Internally, this still calls the setter methods shown in the first example.

`ReconnectAttempts` determines how many times the client will try to connect to
the server before giving up. A value of `-1` represents an infinite number of
times. The default value is `0`. I.e. no reconnection is attempted.

`ReconnectInterval` detemines how long, in milliseconds, the client will wait
between reconnect attempts. The default value is `1000`.

If an exception handler is set on the client, and reconnect attempts is not equal
to `0`. Then the exception handler will not be called until the client gives up
reconnecting.


### NetClient Properties

Just like `NetServer`, `NetClient` also has a set of TCP properties you can set
which affect its behaviour. They have the same meaning as those on `NetServer`.

`NetClient` also has a further set of properties which are used to configure SSL.
We'll discuss those later on.

## SSL Servers

Net servers can also be configured to work with
[Transport Layer Security](http://en.wikipedia.org/wiki/Transport_Layer_Security)
(previously known as SSL).

When a `NetServer` is working as an SSL Server the API of the `NetServer` and
`NetSocket` is identical compared to when it working with standard sockets.
Getting the server to use SSL is just a matter of configuring the `NetServer`
before `listen` is called.

To enabled SSL the function `ssl(TRUE)` must be called on the Net Server.

The server must also be configured with a *key store* and an optional *trust store*.

These are both *Java keystores* which can be managed using the
[keytool](http://docs.oracle.com/javase/6/docs/technotes/tools/solaris/keytool.html)
utility which ships with the JDK.

The keytool command allows you to create keystores, and import and export
certificates from them.

The key store should contain the server certificate. This is mandatory - the
client will not be able to connect to the server over SSL if the server does not
have a certificate.

The key store is configured on the server using the `keyStorePath` and
`keyStorePassword` functions.

The trust store is optional and contains the certificates of any clients it should
trust. This is only used if client authentication is required. 

To configure a server to use server certificates only:

```php
$server = Vertx::createNetServer()
  ->ssl(TRUE)
  ->keyStorePath('/path/to/your/keystore/server-keystore.jks')
  ->keyStorePassword('password');
```

Making sure that `server-keystore.jks` contains the server certificate.

To configure a server to also require client certificates:

```php
$server = Vertx::createNetServer()
  ->ssl(TRUE)
  ->keyStorePath('/path/to/your/keystore/server-keystore.jks')
  ->keyStorePassword('password')
  ->trustStorePath('/path/to/your/truststore/server-truststore.jks')
  ->trustStorePassword('password')
  ->clientAuthRequired(TRUE);
```

Making sure that `server-truststore.jks` contains the certificates of any clients
who the server trusts.

If `clientAuthRequired` is set to `TRUE` and the client cannot provide a
certificate, or it provides a certificate that the server does not trust then
the connection attempt will not succeed.

## SSL Clients

* public [Vertx\Net\NetClient](#net-client) **ssl** ( bool *$ssl* )
* public [Vertx\Net\NetClient](#net-client) **trustAll** ( bool *$trust_all* )
* public [Vertx\Net\NetClient](#net-client) **trustStorePath** ( string *$path* )
* public [Vertx\Net\NetClient](#net-client) **trustStorePassword** ( string *$password* )
* public [Vertx\Net\NetClient](#net-client) **keyStorePath** ( string *$path* )
* public [Vertx\Net\NetClient](#net-client) **keyStorePassword** ( string *$password* )
* public [Vertx\Net\NetClient](#net-client) **clientAuthRequired** ( bool *$required* )

Net Clients can also be easily configured to use SSL. They have the exact same
API when using SSL as when using standard sockets.

To enable SSL on a `NetClient` the function `ssl(TRUE)` is called.

If the `trustAll(TRUE)` is invoked on the client, then the client will trust
all server certificates. The connection will still be encrypted but this mode is
vulnerable to 'man in the middle' attacks. I.e. you can't be sure who you are
connecting to. Use this with caution. Default value is `FALSE`.

If `trustAll(TRUE)` has not been invoked then a client trust store must be
configured and should contain the certificates of the servers that the client
trusts.

The client trust store is just a standard Java key store, the same as the key
stores on the server side. The client trust store location is set by using the
function `trustStorePath` on the `NetClient`. If a server presents a certificate
during connection which is not in the client trust store, the connection attempt
will not succeed.

If the server requires client authentication then the client must present its
own certificate to the server when connecting. This certificate should reside in
the client key store. Again it#s just a regular Java key store. The client keystore
location is set by using the function `keyStorePath` on the `NetClient`. 

To configure a client to trust all server certificates (dangerous):

```php
$client = Vertx::createNetClient()
  ->ssl(TRUE)
  ->trustAll(TRUE);
```

To configure a client to only trust those certificates it has in its trust store:

```php
$client = Vertx::createNetClient()
  ->ssl(TRUE)
  ->trustStorePath('/path/to/your/client/truststore/client-truststore.jks')
  ->trustStorePassword('password');
```

To configure a client to only trust those certificates it has in its trust
store, and also to supply a client certificate:

```php
$client = Vertx::createNetClient()
  ->ssl(TRUE)
  ->trustStorePath('/path/to/your/client/truststore/client-truststore.jks')
  ->trustStorePassword('password')
  ->clientAuthRequired(TRUE)
  ->keyStorePath('/path/to/keystore/holding/client/cert/client-keystore.jks')
  ->keyStorePassword('password');
```


# Flow Control - Streams and Pumps

There are several objects in vert.x that allow data to be read from and written
to in the form of Buffers.

All operations in the vert.x API are non blocking; calls to write data return
immediately and writes are internally queued.

It's not hard to see that if you write to an object faster than it can actually
write the data to its underlying resource then the write queue could grow without
bound - eventually resulting in exhausting available memory.

To solve this problem a simple flow control capability is provided by some
objects in the vert.x API.

Any flow control aware object that can be written to is said to implement
`ReadStream`, and any flow control object that can be read from is said to
implement `WriteStream`.

Let's take an example where we want to read from a `ReadStream` and write the
data to a `WriteStream`.

A very simple example would be reading from a `NetSocket` on a server and writing
back to the same `NetSocket` - since `NetSocket` implements both `ReadStream` and
`WriteStream`, but you can do this between any `ReadStream` and any `WriteStream`,
including HTTP requests and response, async files, WebSockets, etc.

A naive way to do this would be to directly take the data that's been read and
immediately write it to the `NetSocket`, for example:

```php
$server = Vertx::createNetServer();

$server->connectHandler(function($socket) {

  $socket->dataHandler(function($buffer) use ($socket) {

    $socket->write($buffer);

  });

})->listen(1234, 'localhost');
```

There's a problem with the above example: If data is read from the socket faster
than it can be written back to the socket, it will build up in the write queue of
the AsyncFile, eventually running out of RAM. This might happen, for example if
the client at the other end of the socket wasn't reading very fast, effectively
putting back-pressure on the connection.

Since `NetSocket` implements `WriteStream`, we can check if the `WriteStream` is
full before writing to it:

```php
$server = Vertx::createNetServer();

$server->connectHandler(function($socket) {

  $socket->dataHandler(function($buffer) use ($socket) {

    if (!$socket->writeQueueFull) {
      $socket->write($buffer);
    }

  });

})->listen(1234, 'localhost');
```

This example won't run out of RAM but we'll end up losing data if the write queue
gets full. What we really want to do is pause the `NetSocket` when the write
queue is full. Let's do that:

```php
$server = Vertx::createNetServer();

$server->connectHandler(function($socket) {

  $socket->dataHandler(function($buffer) use ($socket) {

    if (!$socket->writeQueueFull) {
      $socket->write($buffer);
    }
    else {
      $socket->pause();
    }

  });

})->listen(1234, 'localhost');
```

We're almost there, but not quite. The `NetSocket` now gets paused when the file
is full, but we also need to *unpause* it when the write queue has processed its
backlog:

```php
$server = Vertx::createNetServer();

$server->connectHandler(function($socket) {

  $socket->dataHandler(function($buffer) use ($socket) {

    if (!$socket->writeQueueFull) {
      $socket->write($buffer);
    }
    else {
      $socket->pause();

      $socket->drainHandler(function() {
        $socket->resume();
      });
    }

  });

})->listen(1234, 'localhost');
```

And there we have it. The `drainHandler` event handler will get called when the
write queue is ready to accept more data, this resumes the `NetSocket` which
allows it to read more data.

It's very common to want to do this when writing vert.x applications, so we
provide a helper class called `Vertx\Pump` which does all this hard work
for you. You just feed it the `ReadStream` and the `WriteStream` and it tell it
to start:

```php
$server = Vertx::createNetServer();

$server->connectHandler(function($socket) {

  $pump = new Vertx\Pump($socket, $socket);
  $pump->start();

})->listen(1234, 'localhost');
```

Which does exactly the same thing as the more verbose example.

Let's look at the methods on `ReadStream` and `WriteStream` in more detail:

## ReadStream

`ReadStream` is implemented by `AsyncFile`, `HttpClientResponse`,
`HttpServerRequest`, `WebSocket`, `NetSocket` and `SockJSSocket`.

Methods:

* `dataHandler($handler)`: set a handler which will receive data from the
`ReadStream`. As data arrives the handler will be passed a Buffer.
* `pause()`: pause the handler. When paused no data will be received in the
`dataHandler`.
* `resume()`: resume the handler. The handler will be called if any data
arrives.
* `exceptionHandler($handler)`: Will be called if an exception occurs on the
`ReadStream`.
* `endHandler($handler)`: Will be called when end of stream is reached. This
might be when EOF is reached if the `ReadStream` represents a file, or when
end of request is reached if it's an HTTP request, or when the connection is
closed if it's a TCP socket.

## WriteStream

`WriteStream` is implemented by `AsyncFile`, `HttpClientRequest`,
`HttpServerResponse`, `WebSocket`, `NetSocket` and `SockJSSocket`

Methods:

* `writeBuffer($buffer)`: write a Buffer to the `WriteStream`. This method will
never block. Writes are queued internally and asynchronously written to the
underlying resource.
* `writeQueueMaxSize($size)`: set the number of bytes at which the write
queue is considered *full*, and the function `writeQueueFull()` returns `true`.
Note that, even if the write queue is considered full, if `writeBuffer` is
called the data will still be accepted and queued.
* `writeQueueFull()`: returns `true` if the write queue is considered full.
* `exceptionHandler($handler)`: Will be called if an exception occurs on the
`WriteStream`.
* `drainHandler($handler)`: The handler will be called if the `WriteStream`
is considered no longer full.

## Pump

Instances of `Vertx\Pump` have the following methods:

* `start()`: Start the pump.
* `stop()`: Stops the pump. When the pump starts it is in stopped mode.
* `writeQueueMaxSize()`: This has the same meaning as `writeQueueMaxSize`
on the `WriteStream`.
* `getBytesPumped()`: Returns total number of bytes pumped.

A pump can be started and stopped multiple times.

# Writing HTTP Servers and Clients

## Writing HTTP servers

Vert.x allows you to easily write full featured, highly performant and scalable
HTTP servers.

### Creating an HTTP Server

* public [Vertx\Http\HttpServer](#writing-http-servers) **Vertx::createHttpServer** ( )

To create an HTTP server you invoke the static `createHttpServer` method on the
`Vertx` class.

```php
$server = Vertx::createHttpServer();
```

### Start the Server Listening

* public [Vertx\Http\HttpServer](#writing-http-servers) **Vertx\Http\HttpServer::listen** ( int *$port* [, string *$host = NULL* [, callable *$handler = NULL* ]] )

To tell that server to listen for incoming requests you use the `listen` method:

```php
$server = Vertx::createHttpServer();

$server->listen(8080, 'localhost');
```

The first parameter to `listen` is the port. The second parameter is the hostname
or ip address. If the hostname is omitted it will default to `0.0.0.0` which means
it will listen at all available interfaces.

### Getting Notified of Incoming Requests

* public [Vertx\Http\HttpServer](#writing-http-servers) **Vertx\Http\HttpServer::requestHandler** ( callable *$handler* )

To be notified when a request arrives you need to set a request handler. This is
done by calling the `requestHandler` function of the server, passing in the handler:

```php
$server = Vertx::createHttpServer();

$server->requestHandler(function($request) use ($log) {
  $log->info('An HTTP request has been received.');
});

$server->listen(8080, 'localhost');
```

This displays 'An HTTP request has been received!' every time an HTTP request
arrives on the server. You can try it by running the verticle and pointing your
browser at `http://localhost:8080`.

Similarly to `NetServer`, the return value of the `requestHandler` method is
the server itself, so multiple invocations can be chained together. That means
we can rewrite the above with:

```php
$server = Vertx::createHttpServer();

$server->requestHandler(function($request) use ($log) {
  $log->info('An HTTP request has been received.');
})->listen(8080, 'localhost');
```

Or:


```php
Vertx::createHttpServer()->requestHandler(function($request) use ($log) {
  $log->info('An HTTP request has been received.');
})->listen(8080, 'localhost');
```

### Handling HTTP Requests

So far we have seen how to create an 'HttpServer' and be notified of requests.
Lets take a look at how to handle the requests and do something useful with
them.

When a request arrives, the request handler is called passing in an instance of
`HttpServerRequest`. This object represents the server side HTTP request.

The handler is called when the headers of the request have been fully read.
If the request contains a body, that body may arrive at the server some time
after the request handler has been called.

It contains functions to get the URI, path, request headers and request
parameters. It also contains a `$response` property which is a reference to
an object that represents the server side HTTP response for the object.

#### Request Method

The request object has a property `$method` which is a string representing what
HTTP method was requested. Possible values for `$method` are: `GET`, `PUT`,
`POST`, `DELETE`, `HEAD`, `OPTIONS`, `CONNECT`, `TRACE`, `PATCH`.

#### Request URI

The request object has a property `$uri` which contains the full URI (Uniform
Resource Locator) of the request. For example, if the request URI was:

    /a/b/c/page.html?param1=abc&param2=xyz    

Then `$request->uri` would contain the string `/a/b/c/page.html?param1=abc&param2=xyz`.

Request URIs can be relative or absolute (with a domain) depending on what the
client sent. In many cases they will be relative.

The request uri contains the value as defined in
[Section 5.1.2 of the HTTP specification - Request-URI](http://www.w3.org/Protocols/rfc2616/rfc2616-sec5.html)

#### Request Path

The request object has a property `$path` which contains the path of the request.
For example, if the request URI was:

    /a/b/c/page.html?param1=abc&param2=xyz    

Then `$request->path` would contain the string `/a/b/c/page.html`

#### Request Query

The request object has a property `$query` which contains the query of the request.
For example, if the request URI was:

    /a/b/c/page.html?param1=abc&param2=xyz    

Then `$request->query` would contain the string `param1=abc&param2=xyz`    

#### Request Headers

The request headers are available as the `headers` property of the request
object. The return value is an object that mimics an associative array.

Note that the header keys are always lower-cased before being they are
returned to you.

Here's an example that echoes the headers to the output of the response. Run
it and point your browser at `http://localhost:8080` to see the headers.

```php
$server = Vertx::createHttpServer();

$server->requestHandler(function($request) {

  $str = '';
  foreach ($request->headers as $key => $value) {
    $str .= $key .': '. $value . "\n";
  }

})->listen(8080, 'localhost');
```

#### Request params

Similarly to the headers, the request parameters are available as the
`params` method on the request object. Again, this is an object that
mimics an associative array.

Request parameters are sent on the request URI, after the path. For
example if the URI was:

    /page.html?param1=abc&param2=xyz

Then the params array would be the following:

    array('param1' => 'abc', 'param2' => 'xyz')

#### Reading Data from the Request Body

* public [Vertx\Http\HttpServerRequest](#handling-http-requests) **Vertx\Http\HttpServerRequest::dataHandler** ( callable *$handler* )

Sometimes an HTTP request contains a request body that we want to read. As
previously mentioned the request handler is called when only the headers of
the request have arrived so the `HttpServerRequest` object does not contain
the body. This is because the body may be very large and we don't want to
create problems with exceeding available memory.

To receive the body, you set the `dataHandler` on the request object. This
will then get called every time a chunk of the request body arrives. Here's
an example:

```php
$server = Vertx::createHttpServer();

$server->requestHandler(function($request) use ($log) {

  $request->dataHandler(function($buffer) use ($log) {
    $log->info('I received '. count($buffer) .' bytes.');
  });

})->listen(8080, 'localhost');
```

The `dataHandler` may be called more than once depending on the size of the
body.    

You'll notice this is very similar to how data from `NetSocket` is read. 

The request object implements the `ReadStream` interface so you can pump the
request body to a `WriteStream`. See the chapter on streams and pumps for a
detailed explanation.

* public [Vertx\Http\HttpServerRequest](#handling-http-requests) **Vertx\Http\HttpServerRequest::endHandler** ( callable *$handler* )

In many cases, you know the body is not large and you just want to receive
it in one go. To do this you could do something like the following:

```php
$server = Vertx::createHttpServer();

$server->requestHandler(function($request) use ($log) {

  $body = new Vertx\Buffer();

  $request->dataHandler(function($buffer) {
    $body->appendBuffer($buffer);
  });

  $request->endHandler(function() use ($log) {
    $log->info('The total body received was '. $body->length .' bytes.');
  });

})->listen(8080, 'localhost');
```

Like any `ReadStream` the end handler is invoked when the end of stream is
reached - in this case at the end of the request.

If the HTTP request is using HTTP chunking, then each HTTP chunk of the
request body will correspond to a single call of the data handler.

It's a very common use case to want to read the entire body before processing
it, so vert.x allows a `bodyHandler` to be set on the request object.

The body handler is called only once when the *entire* request body has been
read.

*Beware of doing this with very large requests since the entire request body
will be stored in memory.*

* public [Vertx\Http\HttpServerRequest](#handling-http-requests) **Vertx\Http\HttpServerRequest::bodyHandler** ( callable *$handler* )

Here's an example using `bodyHandler`:

```php
$server = Vertx::createNetServer();

$server->requestHandler(function($request) use ($log) {

  $request->bodyHandler(function($body) use ($log) {
    $log->info('The total body received was '. $body->length() .' bytes.');
  });

})->listen(8080, 'localhost');
```

### HTTP Server Responses 

As previously mentioned, the HTTP request object contains a property `$response`.
This is the HTTP response for the request. You use it to write the response
back to the client.

### Setting Status Code and Message

To set the HTTP status code for the response use the `$statusCode` property, e.g.

```php
$server = Vertx::createNetServer();

$server->requestHandler(function($request) use ($log) {

  $request->response->statusCode = 404;
  $request->response->end();

})->listen(8080, 'localhost');
```

You can also use the `$statusMessage` property to set the status message. If
you do not set the status message a default message will be used.    
  
The default value for `$statusCode` is `200`.    
  

#### Writing HTTP responses

* public [Vertx\Http\HttpServerResponse](#http-server-responses) **Vertx\Http\HttpServerResponse::write** ( [Vertx\Buffer](#buffers) *$buffer* )

To write data to an HTTP response, you invoke the `write` method. This
function can be invoked multiple times before the response is ended. It can
be invoked in a few ways:

With a single buffer:

```php
$myBuffer = new Vertx\Buffer();
$request->response->write($myBuffer);
```

A string. In this case the string will encoded using UTF-8 and the result
written to the wire.

```php
$request->response->write('Hello world!');
```

A string and an encoding. In this case the string will encoded using the
specified encoding and the result written to the wire.     

```php
$request->response->write('Hello world!', 'UTF-16');
```

The `write` method is asynchronous and always returns immediately after the
write has been queued.

The actual write might complete some time later. If you want to be informed
when the actual write has completed you can pass in a function as the third
argument. This function will then be invoked when the write has completed:

```php
$request->response->write('Hello world!', NULL, function() use ($log) {
  $log->info('It has actually been written.');
});
```

If you are just writing a single string or Buffer to the HTTP response you can
write it and end the response in a single call to the `end` method.   

The first call to `write` results in the response header being being written to
the response.

Consequently, if you are not using HTTP chunking then you must set the
`Content-Length` header before writing to the response, since it will be too
late otherwise. If you are using HTTP chunking you do not have to worry. 
   
#### Ending HTTP responses

* public [Vertx\Http\HttpServerResponse](#http-server-responses) **Vertx\Http\HttpServerResponse::end** ( [ [Vertx\Buffer](#buffers) *$buffer = NULL* ] )

Once you have finished with the HTTP response you must call the `end` method
on it.

This function can be invoked in several ways:

With no arguments, the response is simply ended. 

```php
$request->response->end();
```

The function can also be called with a string or Buffer in the same way `write`
is called. In this case it's just the same as calling write with a string or
Buffer followed by calling `end` with no arguments. For example:

```php
$request->response->end("That's all folks.");
```

#### Closing the underlying connection

* public [Vertx\Http\HttpServerResponse](#http-server-responses) **Vertx\Http\HttpServerResponse::close** ( )

You can close the underlying TCP connection of the request by calling the
`close` method.

```php
$request->response->close();
```

#### Response headers

Individual HTTP response headers can be written using the `putHeader`
method. This allows a more fluent API since they can be chained.
For example:

```php
$request->response->putHeader('Some-Header', 'foo')->putHeader('Other-Header', 'bar');
```

You can also put multiple headers in one go:

```php
$request->response->putAllHeaders(array('Some-Header' => 'foo', 'Other-Header' => 'bar'));
```

Response headers must all be added before any parts of the response body
are written.

#### Chunked HTTP Responses and Trailers

Vert.x supports [HTTP Chunked Transfer Encoding](http://en.wikipedia.org/wiki/Chunked_transfer_encoding).
This allows the HTTP response body to be written in chunks, and is normally used
when a large response body is being streamed to a client, whose size is not known
in advance.

You put the HTTP response into chunked mode as follows:

```php
$request->response->chunked = TRUE;
```

Default is non-chunked. When in chunked mode, each call to `$response->write(...)`
will result in a new HTTP chunk being written out.  

When in chunked mode you can also write HTTP response trailers to the response.
These are actually written in the final chunk of the response.

As with headers, individual HTTP response headers can also be written using the
`putTrailer` method. This allows a more fluent API since they can be chained.
For example:

```php
$request->response->putTrailer('Some-Trailer', 'foo')->putTrailer('Other-Trailer', 'bar');
```

You can also put multiple trailers in one go:

```php
$request->response->putAllTrailers(array('Some-Trailer' => 'foo', 'Other-Trailer' => 'bar'));
```

### Serving files directly from disk

* public [Vertx\Http\HttpServerResponse](#http-server-responses) **Vertx\Http\HttpServerResponse::sendFile** ( string *$uri* )

If you were writing a web server, one way to serve a file from disk would be
to open it as an `AsyncFile` and pump it to the HTTP response. Or you could
load it it one go using the file system API and write that to the HTTP response.

Alternatively, vert.x provides a method which allows you to send serve a file
from disk to HTTP response in one operation. Where supported by the underlying
operating system this may result in the OS directly transferring bytes from the
file to the socket without being copied through userspace at all.

Using `sendFile` is usually more efficient for large files, but may be slower
than using `readFile` to manually read the file as a buffer and write it
directly to the response.

To do this use the `sendFile` function on the HTTP response. Here's a simple
HTTP web server that serves static files from the local `web` directory:

```php
$server = Vertx::createHttpServer();

$server->requestHandler(function($request) {

  $file = '';
  if ($request->path == '/') {
    $file = 'index.html';
  }
  else if (substr($request->path, -2) == '..') {
    $file = $request->path;
  }

  $request->response->sendFile('web/'. $file);

})->listen(8080, 'localhost');
```

*Note: If you use `sendFile` while using HTTPS it will copy through userspace,
since if the kernel is copying data directly from disk to socket it doesn't
give us an opportunity to apply any encryption.*

**If you're going to write web servers using vert.x be careful that users cannot
exploit the path to access files outside the directory from which you want to
serve them.**

### Pumping Responses

Since the HTTP Response implements `WriteStream` you can pump to it from any
`ReadStream`, e.g. an `AsyncFile`, `NetSocket` or `HttpServerRequest`.

Here's an example which echoes HttpRequest headers and body back in the HttpResponse.
It uses a pump for the body, so it will work even if the HTTP request body is
much larger than can fit in memory at any one time:

```php
use Vertx\Pump;

$server = Vertx::createHttpServer();

$server->requestHandler(function($request) {

  $request->response->putAllHeaders($request->headers);

  $pump = new Pump($request, $request->response);
  $pump->start();

  $request->endHandler(function() use ($request) {
    $request->response->end();
  });

})->listen(8080, 'localhost');
```

## Writing HTTP Clients

### Creating an HTTP Client

* public [Vertx\Http\HttpClient](#writing-http-clients) **Vertx::createHttpClient** ( )

To create an HTTP client you invoke the static `createHttpClient` method on the
`Vertx` class.

```php
$client = Vertx::createHttpClient();
```

You set the port and hostname (or ip address) that the client will connect to
using the `host` and `port` methods:

```php
$client = Vertx::createHttpClient();

$client->host('foo.com');
$client->port(8181);
```

As with other areas, the PHP API exposes the magic `__get` and `__set` methods on
many objects, so setting the client host and port can also be done like so:

```php
$client->port = 8181;
$client->host = 'foo.com';
```

This type of attribute access applies to most any setter/getter in the PHP API.
Note that values are still validated when setting. Internally, the same setter
method is called as if you had used the method directly.

Alternative, of course, can be chained:

```php
$client = Vertx::createHttpClient()
  ->host('foo.com')
  ->port(8181);
```

A single `HTTPClient` always connects to the same host and port. If you want
to connect to different servers, create more instances.

The default port is `80` and the default host is `localhost`. So if you don't
explicitly set these values that's what the client will attempt to connect to.  

### Pooling and Keep Alive

By default the `HTTPClient` pools HTTP connections. As you make requests a
connection is borrowed from the pool and returned when the HTTP response has ended.

If you do not want connections to be pooled you can call `keepAlive` with `FALSE`:

```php
$client = Vertx::createHttpClient()
  ->port(8181)
  ->host('foo.com')
  ->keepAlive(FALSE);
```

In this case a new connection will be created for each HTTP request and closed
once the response has ended.

You can set the maximum number of connections that the client will pool as follows:

```php
$client = Vertx::createHttpClient()
  ->port(8181)
  ->host('foo.com')
  ->maxPoolSize(10);
```

Of course, you can also use magic setters.

```php
$client = Vertx::createHttpClient();
$client->port = 8181;
$client->host = 'foo.com';
$client->maxPoolSize = 10;
```

The default value is `1`.         

### Closing the client

* public void **Vertx\Http\HttpClient::close** ( )

Vert.x will automatically close any clients when the verticle is stopped, but if
you want to close it explicitly you can:

```php
$client->close();
```

### Making Requests

* public [Vertx\Http\HttpClientRequest](#making-requests) **Vertx\Http\HttpClient::request** ( string *$method* , string *$uri* , callable *$handler* )
* public [Vertx\Http\HttpClientRequest](#making-requests) **Vertx\Http\HttpClient::get** ( string *$uri* , callable *$handler* )
* public [Vertx\Http\HttpClientRequest](#making-requests) **Vertx\Http\HttpClient::put** ( string *$uri* , callable *$handler* )
* public [Vertx\Http\HttpClientRequest](#making-requests) **Vertx\Http\HttpClient::post** ( string *$uri* , callable *$handler* )
* public [Vertx\Http\HttpClientRequest](#making-requests) **Vertx\Http\HttpClient::delete** ( string *$uri* , callable *$handler* )
* public [Vertx\Http\HttpClientRequest](#making-requests) **Vertx\Http\HttpClient::head** ( string *$uri* , callable *$handler* )
* public [Vertx\Http\HttpClientRequest](#making-requests) **Vertx\Http\HttpClient::patch** ( string *$uri* , callable *$handler* )
* public [Vertx\Http\HttpClientRequest](#making-requests) **Vertx\Http\HttpClient::trace** ( string *$uri* , callable *$handler* )
* public [Vertx\Http\HttpClientRequest](#making-requests) **Vertx\Http\HttpClient::options** ( string *$uri* , callable *$handler* )

To make a request using the client you invoke one the methods named after the HTTP
method that you want to invoke.

For example, to make a `POST` request:

```php
$client = Vertx::createHttpClient();

$request = $client->post('http://localhost:8080/some-path/', function($response) use ($log) {
  $log->info('Got a response, status code: '. $response->statusCode);
});

$request->end();
```

To make a PUT request use the `put` method, to make a GET request use the `get`
method, etc.

Legal request methods are: `get`, `put`, `post`, `delete`, `head`, `options`,
`connect`, `trace` and `patch`.

The general modus operandi is you invoke the appropriate method passing in the
request URI as the first parameter, the second parameter is an event handler which will get
called when the corresponding response arrives. The response handler is passed the client
response object as an argument.

The value specified in the request URI corresponds to the Request-URI as specified
in [Section 5.1.2 of the HTTP specification](http://www.w3.org/Protocols/rfc2616/rfc2616-sec5.html).
In most cases it will be a relative URI.

*Please note that the domain/port that the client connects to is determined by
`port` and `host`, and is not parsed from the uri.*

The return value from the appropriate request method is a `Vertx\Http\HttpClientRequest`
object. You can use this to add headers to the request, and to write to the request
body. The request object implements `WriteStream`.

Once you have finished with the request you must call the `end` function.

* public [Vertx\Http\HttpClientRequest](#making-requests) **Vertx\Http\HttpClientRequest::end** ( [ [Vertx\Buffer](#buffers) *$buffer = NULL* ] )

If you don't know the name of the request method in advance there is a general
`request` method which takes the HTTP method as a parameter:

```php
$client = Vertx::createHttpClient()->host('foo.com');

$request = $client->request('POST', '/some-path', function($response) use ($log) {
  $log->info('Got a response, status code: '. $response->statusCode);
});

$request->end();
```

There is also a method called `getNow` which does the same as `get`, but
automatically ends the request. This is useful for simple GETs which don't have
a request body:

```php
$client = Vertx::createHttpClient()->host('foo.com');

$client->getNow('/some-path', function($response) use ($log) {
  $log->info('Got a response, status code: '. $response->statusCode);
});

$request->end();
```

With `getNow` there is no return value.

#### Writing to the request body

* public [Vertx\Http\HttpClientRequest](#making-requests) **Vertx\Http\HttpClientRequest::write** ( [Vertx\Buffer](#buffers) *$buffer* )

Writing to the client request body has a very similar API to writing to the
server response body.

To write data to an `HttpClientRequest` object, you invoke the `write` function.
This function can be called multiple times before the request has ended. It can
be invoked in a few ways:

With a single buffer:

```php
$myBuffer = new Vertx\Buffer();

$request->write($myBuffer);
```

A string. In this case the string will encoded using UTF-8 and the result
written to the wire.

```php
$request->write('Hello world!');
```

A string and an encoding. In this case the string will encoded using the
specified encoding and the result written to the wire.     

```php
$request->write('Hello world!', 'UTF-16');
```

If you are just writing a single string or Buffer to the HTTP request you can
write it and end the request in a single call to the `end` function.   

The first call to `write` results in the request header being being written to
the request.

Consequently, if you are not using HTTP chunking then you must set the
`Content-Length` header before writing to the request, since it will be too late
otherwise. If you are using HTTP chunking you do not have to worry. 


#### Ending HTTP requests

* public void **Vertx\Http\HttpClientRequest::end** ( [ [Vertx\Buffer](#buffers) *$buffer = NULL* ] )

Once you have finished with the HTTP request you must call the `end` function
on it.

This function can be invoked in several ways:

With no arguments, the request is simply ended. 

```php
$request->end();
```

The function can also be called with a string or Buffer in the same way `write`
is called. In this case it's just the same as calling write with a string or
Buffer followed by calling `end` with no arguments.

#### Writing Request Headers

To write headers to the request you can use the `putHeader` method:

```php
$client = Vertx::createHttpClient()->host('foo.com');

$request = $client->post('/some-path', function($response) use ($log) {
  $log->info('Got a response, status code: '. $response->statusCode);
})->putHeader('Some-Header', 'Some-Value')->end();
```

If you want to put more than one header at the same time, you can instead use
the `putAllHeaders` function.

```php
$client->post('/some-uri', function($response) use ($log) {
  $log->info('Got a response, status code: '. $response->statusCode);
})->putAllHeaders(array(
  'Some-Header' => 'Some-Value',
  'Some-Other-Header' => 'Some-Other-Value',
  'Yet-Another-Header' => 'Yet-Another-Value',
))->end();
```

#### HTTP chunked requests

* public [Vertx\Http\HttpClientRequest](#making-requests) **Vertx\Http\HttpClientRequest::chunked** ( bool *$chunked* )

Vert.x supports [HTTP Chunked Transfer Encoding](http://en.wikipedia.org/wiki/Chunked_transfer_encoding)
for requests. This allows the HTTP request body to be written in chunks, and is
normally used when a large request body is being streamed to the server, whose
size is not known in advance.

You put the HTTP request into chunked mode as follows:

```php
$request->chunked = TRUE;
```

or

```php
$request->chunked(TRUE);
```

Default is non-chunked. When in chunked mode, each call to `$request->write(...)`
will result in a new HTTP chunk being written out.  

### HTTP Client Responses

Client responses are received as an argument to the response handler that is
passed into one of the request methods on the HTTP client.

The response object implements `ReadStream`, so it can be pumped to a
`WriteStream` like any other `ReadStream`.

To query the status code of the response use the `statusCode` property. The
`statusMessage` property contains the status message. For example:

```php
$client = Vertx::createHttpClient()->host('foo.com');

$client->getNow('/some-path', function($response) use ($log) {
  $log->info('Server returned status code: '. $response->statusCode);
  $log->info('Server returned status message: '. $response->statusMessage);
});
```

#### Reading Data from the Response Body

* public [Vertx\Http\HttpClientResponse](#http-client-responses) **Vertx\Http\HttpClientResponse::dataHandler** ( callable *$handler* )

The API for reading a http client response body is very similar to the API for
reading a http server request body.

Sometimes an HTTP response contains a request body that we want to read. Like
an HTTP request, the client response handler is called when all the response
headers have arrived, not when the entire response body has arrived.

To receive the response body, you set a `dataHandler` on the response object
which gets called as parts of the HTTP response arrive. Here's an example:

```php
$client = Vertx::createHttpClient()->host('foo.com');

$client->getNow('/some-path', function($response) use ($log) {
  $response->dataHandler(function($buffer) use ($log) {
    $log->info('I received '. $buffer->length .' bytes.');
  });
});
```

The response object implements the `ReadStream` interface so you can pump the
response body to a `WriteStream`. See the chapter on streams and pump for a
detailed explanation. 

The `dataHandler` can be called multiple times for a single HTTP response.

As with a server request, if you wanted to read the entire response body before
doing something with it you could do something like the following:

```php
use Vertx\Buffer;

$client = Vertx::createHttpClient()->host('foo.com');

$client->getNow('/some-path', function($response) use ($log) {

  $body = new Buffer();

  $response->dataHandler(function($buffer) {
    $body->appendBuffer($buffer);
  });

  $response->endHandler(function() use ($log) {
    $log->info('The total body received was '. $buffer->length .' bytes.');
  });

});
```

Like any `ReadStream` the end handler is invoked when the end of stream is
reached - in this case at the end of the response.

If the HTTP response is using HTTP chunking, then each chunk of the response
body will correspond to a single call to the `dataHandler`.

* public [Vertx\Http\HttpClientResponse](#http-client-responses) **Vertx\Http\HttpClientResponse::bodyHandler** ( callable *$handler* )

It's a very common use case to want to read the entire body in one go, so vert.x
allows a `bodyHandler` to be set on the response object.

The body handler is called only once when the *entire* response body has been
read.

*Beware of doing this with very large responses since the entire response body
will be stored in memory.*

Here's an example using `bodyHandler`:

```php
$client = Vertx::createHttpClient()->host('foo.com');

$client->getNow('/some-path', function($response) use ($log) {

  $response->bodyHandler(function($body) use ($log) {
    $log->info('The total body received was '. $body->length() .' bytes.');
  });

});
```

## Pumping Requests and Responses

The HTTP client and server requests and responses all implement either
`ReadStream` or `WriteStream`. This means you can pump between them and any
other read and write streams.
    
### 100-Continue Handling

According to the [HTTP 1.1 specification](http://www.w3.org/Protocols/rfc2616/rfc2616-sec8.html)
a client can set a header `Expect: 100-Continue` and send the request header
before sending the rest of the request body.

The server can then respond with an interim response status `Status: 100
(Continue)` to signify the client is ok to send the rest of the body.

The idea here is it allows the server to authorise and accept/reject the request
before large amounts of data is sent. Sending large amounts of data if the
request might not be accepted is a waste of bandwidth and ties up the server
in reading data that it will just discard.

Vert.x allows you to set a `continueHandler` on the client request object.
This will be called if the server sends back a `Status: 100 (Continue)` response
to signify it is ok to send the rest of the request.

This is used in conjunction with the `sendHead` function to send the head of
the request.

An example will illustrate this:

```php
$client = Vertx::createHttpClient()->host('foo.com');

$request = $client->put('/some-path', function($response) use ($log) {
  $log->info('Got a response '. $response->statusCode);
});

$request->putHeader('Expect', '100-Continue');

$request->continueHandler(function() use ($request) {

  $request->write('Some data').end();

});

$request->sendHead();
```

## HTTPS Servers

HTTPS servers are very easy to write using vert.x.

An HTTPS server has an identical API to a standard HTTP server. Getting the
server to use HTTPS is just a matter of configuring the HTTP Server before `listen`
is called.

Configuration of an HTTPS server is done in exactly the same way as configuring a
`NetServer` for SSL. Please see SSL server chapter for detailed instructions.

## HTTPS Clients

HTTPS clients can also be very easily written with vert.x

Configuring an HTTP client for HTTPS is done in exactly the same way as configuring
a `NetClient` for SSL. Please see SSL client chapter for detailed instructions. 

## Scaling HTTP servers

Scaling an HTTP or HTTPS server over multiple cores is as simple as deploying more
instances of the verticle. For example:

    vertx deploy http_server.php -instances 20

The scaling works in the same way as scaling a `NetServer`. Please see the chapter
on scaling Net Servers for a detailed explanation of how this works.

# Routing HTTP requests with Pattern Matching

* public [Vertx\Http\RouteMatcher](#routing-http-requests-with-pattern-matching) **Vertx\Http\RouteMatcher::all** ( string *$pattern* , callable *$handler* )
* public [Vertx\Http\RouteMatcher](#routing-http-requests-with-pattern-matching) **Vertx\Http\RouteMatcher::allWithRegex** ( string *$regex* , callable *$handler* )
* public [Vertx\Http\RouteMatcher](#routing-http-requests-with-pattern-matching) **Vertx\Http\RouteMatcher::connect** ( string *$pattern* , callable *$handler* )
* public [Vertx\Http\RouteMatcher](#routing-http-requests-with-pattern-matching) **Vertx\Http\RouteMatcher::connectWithRegex** ( string *$regex* , callable *$handler* )
* public [Vertx\Http\RouteMatcher](#routing-http-requests-with-pattern-matching) **Vertx\Http\RouteMatcher::get** ( string *$pattern* , callable *$handler* )
* public [Vertx\Http\RouteMatcher](#routing-http-requests-with-pattern-matching) **Vertx\Http\RouteMatcher::getWithRegex** ( string *$regex* , callable *$handler* )
* public [Vertx\Http\RouteMatcher](#routing-http-requests-with-pattern-matching) **Vertx\Http\RouteMatcher::put** ( string *$pattern* , callable *$handler* )
* public [Vertx\Http\RouteMatcher](#routing-http-requests-with-pattern-matching) **Vertx\Http\RouteMatcher::putWithRegex** ( string *$regex* , callable *$handler* )
* public [Vertx\Http\RouteMatcher](#routing-http-requests-with-pattern-matching) **Vertx\Http\RouteMatcher::post** ( string *$pattern* , callable *$handler* )
* public [Vertx\Http\RouteMatcher](#routing-http-requests-with-pattern-matching) **Vertx\Http\RouteMatcher::postWithRegex** ( string *$regex* , callable *$handler* )
* public [Vertx\Http\RouteMatcher](#routing-http-requests-with-pattern-matching) **Vertx\Http\RouteMatcher::delete** ( string *$pattern* , callable *$handler* )
* public [Vertx\Http\RouteMatcher](#routing-http-requests-with-pattern-matching) **Vertx\Http\RouteMatcher::deleteWithRegex** ( string *$regex* , callable *$handler* )
* public [Vertx\Http\RouteMatcher](#routing-http-requests-with-pattern-matching) **Vertx\Http\RouteMatcher::head** ( string *$pattern* , callable *$handler* )
* public [Vertx\Http\RouteMatcher](#routing-http-requests-with-pattern-matching) **Vertx\Http\RouteMatcher::headWithRegex** ( string *$regex* , callable *$handler* )
* public [Vertx\Http\RouteMatcher](#routing-http-requests-with-pattern-matching) **Vertx\Http\RouteMatcher::trace** ( string *$pattern* , callable *$handler* )
* public [Vertx\Http\RouteMatcher](#routing-http-requests-with-pattern-matching) **Vertx\Http\RouteMatcher::traceWithRegex** ( string *$regex* , callable *$handler* )
* public [Vertx\Http\RouteMatcher](#routing-http-requests-with-pattern-matching) **Vertx\Http\RouteMatcher::patch** ( string *$pattern* , callable *$handler* )
* public [Vertx\Http\RouteMatcher](#routing-http-requests-with-pattern-matching) **Vertx\Http\RouteMatcher::patchWithRegex** ( string *$regex* , callable *$handler* )
* public [Vertx\Http\RouteMatcher](#routing-http-requests-with-pattern-matching) **Vertx\Http\RouteMatcher::options** ( string *$pattern* , callable *$handler* )
* public [Vertx\Http\RouteMatcher](#routing-http-requests-with-pattern-matching) **Vertx\Http\RouteMatcher::optionsWithRegex** ( string *$regex* , callable *$handler* )
* public [Vertx\Http\RouteMatcher](#routing-http-requests-with-pattern-matching) **Vertx\Http\RouteMatcher::noMatch** ( callable *$handler* )

Vert.x lets you route HTTP requests to different handlers based on pattern matching
on the request path. It also enables you to extract values from the path and use
them as parameters in the request.

This is particularly useful when developing REST-style web applications.

To do this you simply create an instance of `Vertx\Http\RouteMatcher` and use it as
handler in an HTTP server. See the chapter on HTTP servers for more information
on setting HTTP handlers. Here's an example:

```php
// Include the RouteMatcher class from the Vertx\Http namespace.
use Vertx\Http\RouteMatcher;

$server = Vertx::createHttpServer();

$routeMatcher = new RouteMatcher();

$server->requestHandler($routeMatcher)->listen(8080, 'localhost');
```

## Specifying matches

You can then add different matches to the route matcher. For example, to send all
GET requests with path `/animals/dogs` to one handler and all GET requests with
path `/animals/cats` to another handler you would do:

```php
use Vertx\Http\RouteMatcher;

$server = Vertx::createHttpServer();

$routeMatcher = new RouteMatcher();

$routeMatcher->get('/animals/dogs', function($request) {
  $request->response->end('You requested dogs.');
});

$routeMatcher->get('/animals/cats', function($request) {
  $request->response->end('You requested cats.');
});

$server->requestHandler($routeMatcher)->listen(8080, 'localhost');
```

Corresponding methods exist for each HTTP method - `get`, `post`, `put`, `delete`,
`head`, `options`, `trace`, `connect` and `patch`.

There's also an `all` method which applies the match to any HTTP request method.

The handler specified to the method is just a normal HTTP server request handler,
the same as you would supply to the `requestHandler` method of the HTTP server.

You can provide as many matches as you like and they are evaluated in the order
you added them, the first matching one will receive the request.

A request is sent to at most one handler.

## Extracting parameters from the path

If you want to extract parameters from the path, you can do this too, by using
the `:` (colon) character to denote the name of a parameter. For example:

```php
use Vertx\Http\RouteMatcher;

$server = Vertx::createHttpServer();

$routeMatcher = new RouteMatcher();

$routeMatcher->put('/:blogname/:post', function($request) {
  $blogName = $request->params->blogname;
  $post = $request->params->post;
  $request->response->end('blogname is '. $blogName .', post is '. $post);
});

$server->requestHandler($routeMatcher)->listen(8080, 'localhost');
```

Any params extracted by pattern matching are added to the map of request parameters.

In the above example, a PUT request to `/myblog/post1` would result in the variable
`$blogName` getting the value `myblog` and the variable `$post` getting the value `post1`.

Valid parameter names must start with a letter of the alphabet and be followed by any
letters of the alphabet or digits.

## Extracting params using Regular Expressions

Regular Expressions can be used to extract more complex matches. In this case capture
groups are used to capture any parameters.

Since the capture groups are not named they are added to the request with names
`param0`, `param1`, `param2`, etc. 

Corresponding methods exist for each HTTP method - `getWithRegEx`, `postWithRegEx`,
`putWithRegEx`, `deleteWithRegEx`, `headWithRegEx`, `optionsWithRegEx`, `traceWithRegEx`,
`connectWithRegEx` and `patchWithRegEx`.

There's also an `allWithRegEx` method which applies the match to any HTTP request method.

For example:

```php
use Vertx\Http\RouteMatcher;

$server = Vertx::createHttpServer();

$routeMatcher = new RouteMatcher();

$routeMatcher->allWithRegEx('\/([^\/]+)\/([^\/]+)', function($request) {
  $first = $request->params->param0;
  $second = $request->params->param1;
  $request->response->end('first is '. $first .' and second is '. $second);
});

$server->requestHandler($routeMatcher)->listen(8080, 'localhost');
```

Run the above and point your browser at `http://localhost:8080/animals/cats`.

It will display 'first is animals and second is cats'.         
    
## Handling requests where nothing matches

You can use the `noMatch` function to specify a handler that will be called if
nothing matches. If you don't specify a no match handler and nothing matches, a
404 will be returned.

```php
$routeMatcher->noMatch(function($request) {
  $request->response->end('Nothing matched!');
});
```

# WebSockets

[WebSockets](http://en.wikipedia.org/wiki/WebSocket) are a feature of HTML 5 that
allows a full duplex socket-like connection between HTTP servers and HTTP
clients (typically browsers).

## WebSockets on the server

To use WebSockets on the server you create an HTTP server as normal, but instead
of setting a `requestHandler` you set a `websocketHandler` on the server.

```php
$server = Vertx::createHttpServer();

$server->websocketHandler(function($websocket) use ($log) {

  $log->info('A websocket has connected!');

})->listen(8080, 'localhost');
```

### Reading from and Writing to WebSockets    

The `websocket` instance passed into the handler implements both `ReadStream`
and `WriteStream`, so you can read and write data to it in the normal ways. I.e
by setting a `dataHandler` and calling the `writeBuffer` method.

See the chapter on `NetSocket` and streams and pumps for more information.

For example, to echo all data received on a WebSocket:

```php
// Include the Pump from the Vertx namespace.
use Vertx\Pump;

$server = Vertx::createHttpServer();

$server->websocketHandler(function($websocket) {

  $pump = new Pump($websocket, $websocket);
  $pump->start();

})->listen(8080, 'localhost');
```

The `websocket` instance also has method `writeBinaryFrame` for writing binary
data. This has the same effect as calling `writeBuffer`.

Another method `writeTextFrame` also exists for writing text data. This is
equivalent to calling 

```php
$websocket->writeBuffer(new Vertx\Buffer('some-string'));
```

### Rejecting WebSockets

Sometimes you may only want to accept WebSockets which connect at a specific path.

To check the path, you can query the `path` property of the `websocket`. You can
then call the `reject` function to reject the websocket.

```php
use Vertx\Pump;

$server = Vertx::createHttpServer();

$server->websocketHandler(function($websocket) {

  if ($websocket->path == '/services/echo') {
    $pump = new Pump($websocket, $websocket);
    $pump.start();
  }
  else {
    $websocket->reject();
  }

})->listen(8080, 'localhost');

```

## WebSockets on the HTTP client

To use WebSockets from the HTTP client, you create the HTTP client as normal,
then call the `connectWebsocket` function, passing in the URI that you wish to
connect to at the server, and a handler.

The handler will then get called if the WebSocket successfully connects. If the
WebSocket does not connect - perhaps the server rejects it, then any exception
handler on the HTTP client will be called.

Here's an example of WebSocket connection;

```php
$client = Vertx::createHttpClient();

$client->connectWebsocket('http://localhost:8080/some-uri', function($websocket) use ($log) {

  $log->info('The websocket has connected!.');

});
```

Again, the client side WebSocket implements `ReadStream` and `WriteStream`, so
you can read and write to it in the same way as any other stream object. 

## WebSockets in the browser

To use WebSockets from a compliant browser, you use the standard WebSocket API.
Here's some example client side JavaScript which uses a WebSocket. 

    <script>
    
        var socket = new WebSocket("ws://localhost:8080/services/echo");

        socket.onmessage = function(event) {
            alert("Received data from websocket: " + event.data);
        }
        
        socket.onopen = function(event) {
            alert("Web Socket opened");
            socket.send("Hello World");
        };
        
        socket.onclose = function(event) {
            alert("Web Socket closed");
        };
    
    </script>

For more information see the [WebSocket API documentation](http://dev.w3.org/html5/websockets/) 

## Routing WebSockets with Pattern Matching

**TODO**

# SockJS

WebSockets are a new technology, and many users are still using browsers that
do not support them, or which support older, pre-final, versions.

Moreover, WebSockets do not work well with many corporate proxies. This means
that's it's not possible to guarantee a WebSocket connection is going to
succeed for every user.

Enter SockJS.

SockJS is a client side JavaScript library and protocol which provides a simple
WebSocket-like interface to the client side JavaScript developer irrespective
of whether the actual browser or network will allow real WebSockets.

It does this by supporting various different transports between browser and
server, and choosing one at runtime according to browser and network capabilities.
All this is transparent to you - you are simply presented with the WebSocket-like
interface which *just works*.

Please see the [SockJS website](https://github.com/sockjs/sockjs-client) for
more information.

## SockJS Server

Vert.x provides a complete server side SockJS implementation.

This enables vert.x to be used for modern, so-called *real-time* (this is the
*modern* meaning of *real-time*, not to be confused by the more formal
pre-existing definitions of soft and hard real-time systems) web applications
that push data to and from rich client-side JavaScript applications, without
having to worry about the details of the transport.

To create a SockJS server you simply create a HTTP server as normal and then
invoke the static `createSockJSServer` method on the `Vertx` class, specifying
the HTTP server:

```php
$httpServer = Vertx::createHttpServer();

$sockJSServer = Vertx::createSockJSServer($httpServer);
```

Each SockJS server can host multiple *applications*.

Each application is defined by some configuration, and provides a handler which
gets called when incoming SockJS connections arrive at the server.     

For example, to create a SockJS echo application:

```php
$httpServer = Vertx::createHttpServer();

$sockJSServer = Vertx::createSockJSServer($httpServer);

$config = array('prefix' => '/echo');

$sockJSServer->installApp($config, function($socket) {
  $pump = new Vertx\Pump($socket, $socket);
  $pump->start();
});

$httpServer->listen(8080);
```

The configuration is an associative array that takes the following fields:

* `prefix`: A url prefix for the application. All http requests whose paths
begins with selected prefix will be handled by the application. This property
is mandatory.
* `insert_JSESSIONID`: Some hosting providers enable sticky sessions only to
requests that have JSESSIONID cookie set. This setting controls if the server
should set this cookie to a dummy value. By default setting JSESSIONID cookie
is enabled. More sophisticated beaviour can be achieved by supplying a function.
* `session_timeout`: The server sends a `close` event when a client receiving
connection have not been seen for a while. This delay is configured by this
setting. By default the `close` event will be emitted when a receiving
connection wasn't seen for 5 seconds.
* `heartbeat_period`: In order to keep proxies and load balancers from closing
long running http requests we need to pretend that the connecion is active and
send a heartbeat packet once in a while. This setting controlls how often this
is done. By default a heartbeat packet is sent every 25 seconds.
* `max_bytes_streaming`: Most streaming transports save responses on the client
side and don't free memory used by delivered messages. Such transports need to
be garbage-collected once in a while. `max_bytes_streaming` sets a minimum
number of bytes that can be send over a single http streaming request before
it will be closed. After that client needs to open new request. Setting this
value to one effectively disables streaming and will make streaming transports
to behave like polling transports. The default value is 128K.    
* `library_url`: Transports which don't support cross-domain communication
natively ('eventsource' to name one) use an iframe trick. A simple page is
served from the SockJS server (using its foreign domain) and is placed in an
invisible iframe. Code run from this iframe doesn't need to worry about
cross-domain issues, as it's being run from domain local to the SockJS server.
This iframe also does need to load SockJS javascript client library, and this
option lets you specify its url (if you're unsure, point it to the latest
minified SockJS client release, this is the default). The default value is
`http://cdn.sockjs.org/sockjs-0.1.min.js`

## Reading and writing data from a SockJS server

The object passed into the SockJS handler implements `ReadStream` and
`WriteStream` much like `NetSocket` or `WebSocket`. You can therefore use the
standard API for reading and writing to the SockJS socket or using it in pumps.

See the chapter on Streams and Pumps for more information.

```php
$httpServer = Vertx::createHttpServer();

$sockJSServer = Vertx::createSockJSServer($httpServer);

$config = array('prefix' => '/echo');

$sockJSServer->installApp($config, function($socket) {

  $socket->dataHandler(function($buffer) use ($socket) {
    $socket->writeBuffer($buffer);
  });

});

$httpServer->listen(8080);
```

## SockJS client

For full information on using the SockJS client library please see the
SockJS website. A simple example:

    <script>
       var sock = new SockJS('http://mydomain.com/my_prefix');
       
       sock.onopen = function() {
           console.log('open');
       };
       
       sock.onmessage = function(e) {
           console.log('message', e.data);
       };
       
       sock.onclose = function() {
           console.log('close');
       };
    </script>   
    
As you can see the API is very similar to the WebSockets API.    
            
# SockJS - EventBus Bridge

## Setting up the Bridge

By connecting up SockJS and the vert.x event bus we create a distributed
event bus which not only spans multiple vert.x instances on the server side,
but can also include client side JavaScript running in browsers.

We can therefore create a huge distributed bus encompassing many browsers
and servers. The browsers don't have to be connected to the same server as
long as the servers are connected.

On the server side we have already discussed the event bus API.

We also provide a client side JavaScript library called `vertxbus.js` which
provides the same event bus API, but on the client side.

This library internally uses SockJS to send and receive data to a SockJS
vert.x server called the SockJS bridge. It's the bridge's responsibility
to bridge data between SockJS sockets and the event bus on the server side.

Creating a Sock JS bridge is simple. You just call the `bridge` method
on the SockJS server.

You will also need to secure the bridge (see below).

The following example creates and starts a SockJS bridge which will bridge
any events sent to the path `eventbus` on to the server side event bus.

```php
$httpServer = Vertx::createHttpServer();

$sockJSServer = Vertx::createSockJSServer($httpServer);

$sockJSServer->bridge(array('prefix' => '/eventbus'), array(), array());

$httpServer->listen(8080);
```

The SockJS bridge currently only works with JSON (array) event bus messages.    

## Using the Event Bus from client side JavaScript

Once you've set up a bridge, you can use the event bus from the client
side as follows:

In your web page, you need to load the script `vertxbus.js`, then you
can access the vert.x event bus API. Here's a rough idea of how to use
it. For a full working examples, please consult the bundled examples.

    <script src="http://cdn.sockjs.org/sockjs-0.2.1.min.js"></script>
    <script src='vertxbus.js'></script>

    <script>

        var eb = new vertx.EventBus('http://localhost:8080/eventbus');
        
        eb.onopen = function() {
        
          eb.registerHandler('some-address', function(message) {

            console.log('received a message: ' + JSON.stringify(message);

          });

          eb.send('some-address', {name: 'tim', age: 587});
        
        }
       
    </script>

You can find `vertxbus.js` in the `client` directory of the vert.x distribution.

The first thing the example does is to create a instance of the event bus

    var eb = new vertx.EventBus('http://localhost:8080/eventbus'); 

The parameter to the constructor is the URI where to connect to the event
bus. Since we create our bridge with the prefix `eventbus` we will connect there.

You can't actually do anything with the bridge until it is opened. When it
is open the `onopen` handler will be called.

The client side event bus API for registering and unregistering handlers and
for sending messages is exactly the same as the server side one. Please consult
the chapter on the event bus for full information.    

**There is one more thing to do before getting this working, please read the following section....**

## Securing the Bridge

If you started a bridge like in the above example without securing it, and
attempted to send messages through it you'd find that the messages mysteriously
disappeared. What happened to them?

For most applications you probably don't want client side JavaScript being able
to send just any message to any verticle on the server side or to all other
browsers.

For example, you may have a persistor verticle on the event bus which allows
data to be accessed or deleted. We don't want badly behaved or malicious clients
being able to delete all the data in your database! Also, we don't necessarily
want any client to be able to listen in on any topic.

To deal with this, a SockJS bridge will, by default refuse to let through any
messages. It's up to you to tell the bridge what messages are ok for it to pass
through. (There is an exception for reply messages which are always allowed
through).

In other words the bridge acts like a kind of firewall which has a default
*deny-all* policy.

Configuring the bridge to tell it what messages it should pass through is easy.
You pass in two arrays of JSON objects that represent *matches*, as the final
argument in the call to `bridge`.

The first array is the *inbound* list and represents the messages that you want
to allow through from the client to the server. The second array is the
*outbound* list and represents the messages that you want to allow through from
the server to the client.

Each match can have up to three fields:

1. `address`: This represents the exact address the message is being sent to.
If you want to filter messages based on an exact address you use this field.
2. `address_re`: This is a regular expression that will be matched against the
address. If you want to filter messages based on a regular expression you use
this field. If the `address` field is specified this field will be ignored.
3. `match`: This allows you to filter messages based on their structure. Any
fields in the match must exist in the message with the same values for them to
be passed. This currently only works with JSON messages.

When a message arrives at the bridge, it will look through the available
permitted entries.

* If an `address` field has been specified then the `address` must match exactly
with the address of the message for it to be considered matched.

* If an `address` field has not been specified and an `address_re` field has been
specified then the regular expression in `address_re` must match with the address
of the message for it to be considered matched.

* If a `match` field has been specified, then also the structure of the message
must match.

Here is an example:

```php
$httpServer = Vertx::createHttpServer();

$sockJSServer = Vertx::createSockJSServer($httpServer);

$sockJSServer->bridge(array('prefix' => '/eventbus'), array(
  array('address' => 'demo.orderMgr'),
  array('address' => 'demo.persistor', 'match' => array('action' => 'find', 'collection' => 'albums')),
  array('match' => array('wibble' => 'foo')),
), array(
  array('address' => 'ticket.mystock'),
  array('address_re' => 'news\\..+'),
));

$server->listen(8080);
```

To let all messages through you can specify two arrays with a single empty
array which will match all messages.

```php
$sockJSServer->bridge(array('prefix' => '/eventbus', array(array()), array(array())));
```

**Be very careful!**

## Messages that require authorization

The bridge can also refuse to let certain messages through if the user is
not authorised.

To enable this you need to make sure an instance of the `vertx.auth-mgr`
module is available on the event bus. (Please see the modules manual for
a full description of modules).

To tell the bridge that certain messages require authorisation before being
passed, you add the field `requires_auth` with the value of `true` in the
match. The default value is `false`. For example, the following match:

```php
array(
  'address' => 'demo.persistor',
  'match' => array(
    'action' => 'find',
    'collection' => 'albums',
  ),
  'requires_auth' => TRUE,
)
```

This tells the bridge that any messages to save orders in the `orders`
collection, will only be passed if the user is successful authenticated
(i.e. logged in ok) first.    
    
When a message is sent from the client that requires authorisation, the
client must pass a field `sessionID` with the message that contains the
unique session ID that they obtained when they logged in with the `auth-mgr`.

When the bridge receives such a message, it will send a message to the
`auth-mgr` to see if the session is authorised for that message. If the session
is authorised the bridge will cache the authorisation for a certain amount of
time (five minutes by default)

# File System

Vert.x lets you manipulate files on the file system. File system operations are
asynchronous and take a handler function as the last argument. This function
will be called when the operation is complete, or an error has occurred.
The first argument passed into the callback is the result. If the called method
does not return a result value, the result will not be present. The second argument
will be a Java exception. If no exception was thrown then this will be `NULL`.

## Synchronous forms

For convenience, we also provide synchronous forms of most operations. It's
highly recommended the asynchronous forms are always used for real applications.

The synchronous form does not take a handler as an argument and returns its
results directly. The name of the synchronous method is the same as the name
as the asynchronous form with `Sync` appended.

## copy

Copies a file.

This method can be called in two different ways:

* public [Vertx\File\FileSystem](#file-system) **Vertx\File\FileSystem::copy** ( string *$source* , string *$destination* , callable *$handler* )
* public [Vertx\File\FileSystem](#file-system) **Vertx\File\FileSystem::copySync** ( string *$source* , string *$destination* )

Non recursive file copy. `$source` is the source file name. `$destination` is the
destination file name.

Here's an example:

```php
Vertx::fileSystem()->copy('foo.dat', 'bar.dat', function($error) use ($log) {
  if (!$error) {
    $log->info('Copy was successful!');
  }
});
```

## copyRecursive

* public [Vertx\File\FileSystem](#file-system) **Vertx\File\FileSystem::copyRecursive** ( string *$source* , string *$destination* , callable *$handler* )
* public [Vertx\File\FileSystem](#file-system) **Vertx\File\FileSystem::copyRecursiveSync** ( string *$source* , string *$destination* )

Recursive copy. `$source` is the source file name. `$destination` is the destination
file name. `$recursive` is a boolean flag - if `TRUE` and source is a directory, then
a recursive copy of the directory and all its contents will be attempted.

## move

* public [Vertx\File\FileSystem](#file-system) **Vertx\File\FileSystem::move** ( string *$source* , string *$destination* , callable *$handler* )
* public [Vertx\File\FileSystem](#file-system) **Vertx\File\FileSystem::moveSync** ( string *$source* , string *$destination* )

Moves a file.

`$source` is the source file name. `$destination` is the destination file name.

## truncate

* public [Vertx\File\FileSystem](#file-system) **Vertx\File\FileSystem::truncate** ( string *$file* , int *$length* , callable *$handler* )
* public [Vertx\File\FileSystem](#file-system) **Vertx\File\FileSystem::truncateSync** ( string *$file* , int *$length* )

Truncates a file.

`$file` is the file name of the file to truncate. `$length` is the length in bytes to
truncate it to.

## props

* public [Vertx\File\FileSystem](#file-system) **Vertx\File\FileSystem::props** ( string *$file* , callable *$handler* )
* public [Vertx\File\FileProps](#fileprops) **Vertx\File\FileSystem::propsSync** ( string *$file* )

Retrieve properties of a file.

`$file` is the file name. The props are returned in the handler. The results is
an object with the following properties:

### FileProps

* `creationTime`. Time of file creation.
* `lastAccessTime`. Time of last file access.
* `lastModifiedTime`. Time file was last modified.
* `isDirectory`. This will have the value `TRUE` if the file is a directory.
* `isRegularFile`. This will have the value `TRUE` if the file is a regular file
(not symlink or directory).
* `isSymbolicLink`. This will have the value `TRUE` if the file is a symbolic link.
* `isOther`. This will have the value `TRUE` if the file is another type.

Here's an example:

```php
Vertx::fileSystem()->props('some-file.txt', function($props, $error) use ($log) {
  if ($error) {
    $log->info('Failed to retrieve file props: '. $error);
  }
  else {
    $log->info('File props are:');
    $log->info('Last accessed: '. $props->lastAccessTime);
    // etc
  }
});
```

## lprops

* public [Vertx\File\FileSystem](#file-system) **Vertx\File\FileSystem::lprops** ( string *$file* , callable *$handler* )
* public [Vertx\File\FileProps](#fileprops) **Vertx\File\FileSystem::lpropsSync** ( string *$file* )

Retrieve properties of a link. This is like `props` but should be used when you
want to retrieve properties of a link itself without following it.

It takes the same arguments and provides the same results as `props`.

## link

* public [Vertx\File\FileSystem](#file-system) **Vertx\File\FileSystem::link** ( string *$link* , string *$existing* , callable *$handler* )
* public [Vertx\File\FileSystem](#file-system) **Vertx\File\FileSystem::linkSync** ( string *$link* , string *$existing* )

Create a hard link.

`$link` is the name of the link. `$existing` is the existing file (i.e. where to
point the link at).

## symlink

* public [Vertx\File\FileSystem](#file-system) **Vertx\File\FileSystem::symlink** ( string *$link* , string *$existing* , callable *$handler* )
* public [Vertx\File\FileSystem](#file-system) **Vertx\File\FileSystem::symlinkSync** ( string *$link* , string *$existing* )

Create a symbolic link.

`$link` is the name of the symlink. `$existing` is the existing file (i.e. where
to point the symlink at).

## unlink

* public [Vertx\File\FileSystem](#file-system) **Vertx\File\FileSystem::unlink** ( string *$link* , callable *$handler* )
* public [Vertx\File\FileSystem](#file-system) **Vertx\File\FileSystem::unlinkSync** ( string *$link* )

Unlink (delete) a link.

`$link` is the name of the link to unlink.

## readSymLink

* public [Vertx\File\FileSystem](#file-system) **Vertx\File\FileSystem::readSymLink** ( string *$link* , callable *$handler* )
* public string **Vertx\File\FileSystem::readSymLinkSync** ( string *$link* )

Reads a symbolic link. I.e returns the path representing the file that the
symbolic link specified by `$link` points to.

`link` is the name of the link to read. An usage example would be:

```php
Vertx::fileSystem()->readSymLink('somelinke', function($result, $error) use ($log) {
  if (!$error) {
    $log->info('Link points at '. $result);
  }
});
```

## delete

* public [Vertx\File\FileSystem](#file-system) **Vertx\File\FileSystem::delete** ( string *$source* , string *$destination* , callable *$handler* )
* public [Vertx\File\FileSystem](#file-system) **Vertx\File\FileSystem::deleteSync** ( string *$source* , string *$destination* )

Deletes a file.

`$file` is the file name.

## deleteRecursive

* public [Vertx\File\FileSystem](#file-system) **Vertx\File\FileSystem::deleteRecursive** ( string *$directory* , callable *$handler* )
* public [Vertx\File\FileSystem](#file-system) **Vertx\File\FileSystem::deleteRecursiveSync** ( string *$directory* )

Deletes a directory recursively.

`$directory` is the directory name.

## mkdir

* public [Vertx\File\FileSystem](#file-system) **Vertx\File\FileSystem::mkdir** ( string *$path* , string|null *$perms* , callable *$handler* )
* public [Vertx\File\FileSystem](#file-system) **Vertx\File\FileSystem::mkdirSync** ( string *$path* [, string *$perms = NULL* ] )

Creates a directory.

```php
Vertx::fileSystem()->mkdir('a/b/c', NULL, function($result, $error) {
  if (!$error) {
    $log->info('Directory created ok.');
  }
});
```

## readDir

* public [Vertx\File\FileSystem](#file-system) **Vertx\File\FileSystem::readDir** ( string *$path* , string|null *$filter* , callable *$handler* )
* public [Vertx\File\FileSystem](#file-system) **Vertx\File\FileSystem::readDirSync** ( string *$path* [, string *$filter = NULL* ] )

Reads a directory. I.e. lists the contents of the directory.

```php
Vertx::fileSystem()->readDir('mydirectory', '.*\.txt', function($results, $error) use ($log) {
  if (!$error) {
    $log->info('Directory contains these .txt files');
    foreach ($results as $result) {
      $log->info($result);
    }
  }
});
```

The filter is a regular expression.    
  
## readFile

* public [Vertx\File\FileSystem](#file-system) **Vertx\File\FileSystem::readFile** ( string *$file* , callable *$handler* )
* public [Vertx\File\FileSystem](#file-system) **Vertx\File\FileSystem::readFileSync** ( string *$file* )

Read the entire contents of a file in one go. *Be careful if using this with
large files since the entire file will be stored in memory at once*.

`$file` is the file name of the file to read.

The body of the file will be returned as a `Buffer` in the handler.

Here is an example:

```php
Vertx::fileSystem()->readFile('myfile.dat', function($result, $error) use ($log) {
  if (!$error) {
    $log->info('File contains: '. $result->length() .' bytes');
  }
});
```

## writeFile

* public [Vertx\File\FileSystem](#file-system) **Vertx\File\FileSystem::writeFile** ( string *$file* , [Vertx\Buffer](#buffers) *$buffer* , callable *$handler* )
* public [Vertx\File\FileSystem](#file-system) **Vertx\File\FileSystem::writeFileSync** ( string *$file* , [Vertx\Buffer](#buffers) *$buffer* )

Writes an entire `Buffer` or a string into a new file on disk.

`$file` is the file name. `$data` is a `Buffer` or string.

## createFile

* public [Vertx\File\FileSystem](#file-system) **Vertx\File\FileSystem::createFile** ( string *$file* , string|null *$perms* , callable *$handler* )
* public [Vertx\File\FileSystem](#file-system) **Vertx\File\FileSystem::createFileSync** ( string *$file* [, string *$perms = NULL* ] )

Creates a new empty file.

## exists

* public [Vertx\File\FileSystem](#file-system) **Vertx\File\FileSystem::exists** ( string *$file* , callable *$handler* )
* public bool **Vertx\File\FileSystem::existsSync** ( string *$file* )

Checks if a file exists.

`$file` is the file name.

The result is returned in the handler.

```php
Vertx::fileSystem()->exists('some-file.txt', function($result, $error) use ($log) {
  if (!$error) {
    $log->info('File '. $result ? 'exists' : 'does not exist');
  }
});
```

## fsProps

* public [Vertx\File\FileSystem](#file-system) **Vertx\File\FileSystem::fsProps** ( string *$file* , callable *$handler* )
* public [Vertx\File\FileSystemProps](#filesystemprops) **Vertx\File\FileSystem::fsPropsSync** ( string *$file* )

Get properties for the file system.

`$file` is any file on the file system.

### FileSystemProps

The result is returned in the handler. The result object has the following fields:

* `totalSpace`. Total space on the file system in bytes.
* `unallocatedSpace`. Unallocated space on the file system in bytes.
* `usableSpace`. Usable space on the file system in bytes.

Here is an example:

```php
Vertx::fileSystem()->fsProps('mydir', function($result, $error) use ($log) {
  if (!$error) {
    $log->info('Total space: '. $result->totalSpace);
  }
});
```

## open

#### TODO

## AsyncFile

Instances of `AsyncFile` are returned from calls to `open` and you use them to
read from and write to files asynchronously. They allow asynchronous random
file access.

AsyncFile implements the `ReadStream` and `WriteStream` interfaces, allowing
them to be used in related APIs.

They also allow you to read and write directly to them with the following methods:

* public [Vertx\File\AsyncFile](#asyncfile) **Vertx\File\AsyncFile::read** ( [Vertx\Buffer](#buffers) *$buffer* , int *$offset* , int *$position* , int *$length* , callable *$handler* )
* public [Vertx\File\AsyncFile](#asyncfile) **Vertx\File\AsyncFile::write** ( [Vertx\Buffer](#buffers) *$buffer* , int *$position* , callable *$handler* )

### Random access writes

#### TODO

### Random access reads

#### TODO

### Flushing data to underlying storage

If the AsyncFile was not opened with `$flush = TRUE`, then you can manually
flush any writes from the OS cache by calling the `flush` method.

### Using AsyncFile as `ReadStream` and `WriteStream`

#### TODO

### Closing an AsyncFile

To close an AsyncFile call the `close` method. Closing is asynchronous and
if you want to be notified when the close has been completed you can specify
a handler function as an argument to `close`.

```php
$fileSystem->close(function() {
  Vertx::logger()->info('File system was closed!');
});
```

This work is adapted from the [Vert.x website](http://vertx.io/) and is licensed
under the [Creative Commons Attribution-ShareAlike 3.0 Unported License](http://creativecommons.org/licenses/by-sa/3.0/).
