package io.vertx.lang.php.util;

import com.caucho.quercus.env.*;
import org.vertx.java.core.json.JsonArray;
import org.vertx.java.core.json.JsonObject;

import java.util.Arrays;

/**
 * Created by leng on 10/15/14.
 */
public class JSON {

  public static StringValue encode(Env env, Value jsonArr) {
    if(!jsonArr.isArray()){
      return jsonArr.toStringValue();
    }

    boolean hasjsonArr = PhpTypes.notNull(jsonArr);
    if (hasjsonArr) {
      Value[] jsonKeys = ((ArrayValue)jsonArr).keysToArray();

      boolean isAssoc = false;
      for(int i = 0; i < jsonKeys.length; i++){
        final String ks = jsonKeys[i].toString();
        if(!ks.equals(String.valueOf(i))){
          isAssoc = true;
          break;
        }
      }

      if (isAssoc) {
        final JsonObject obj = PhpTypes.arrayToJsonObject(env, jsonArr);
        try {
//          System.out.println("[encode] " + obj.toString());
          return env.createString(obj.toString());
        }
        catch (Exception err) {
          return env.createString("null");
        }
      }
      else {
        final JsonArray arr = PhpTypes.arrayToJsonArray(env, jsonArr);
        try {
//          System.out.println("[encode] " + arr.toString());
          return env.createString(arr.toString());
        }
        catch (Exception err) {
          return env.createString("null");
        }
      }
    }
    return env.createString("null");
  }

  public static Value decode(Env env, StringValue jsonStr, BooleanValue toArray) {
    if(toArray!=null && toArray.toBoolean()) {
//      System.out.println("[decode] " + jsonStr.toString());
      final String str = jsonStr.toString();
      if(jsonStr.startsWith("[")){
        try{
          final JsonArray jsonArr = new JsonArray(str);
          return PhpTypes.arrayFromJson(env, jsonArr);
        }
        catch(Exception err) {
//          System.out.println("ERR 0 ========= " + err.getMessage());
//          err.printStackTrace();
        }
      }
      else{
        try {
          final JsonObject jsonObj = new JsonObject(str);
          return PhpTypes.arrayFromJson(env, jsonObj);
        }
        catch(Exception err2) {
//          System.out.println("ERR 1 ========= " + err2.getMessage());
//          err2.printStackTrace();
        }
      }
      return null;
    }
    else {
      final String str = jsonStr.toString();
      if(jsonStr.startsWith("[")) {
        try {
          final JsonArray jsonArr = new JsonArray(str);
          return PhpTypes.arrayFromJson(env, jsonArr, true);
        } catch (Exception err) {}
      }
      else {
        try {
          final JsonObject jsonObj = new JsonObject(str);
          return PhpTypes.arrayFromJson(env, jsonObj, true);
        } catch (Exception err2) {}
      }
    }
    return null;
  }

  public static Value decode(Env env, StringValue jsonStr) {
    return decode(env, jsonStr, BooleanValue.create(false));
  }

}
