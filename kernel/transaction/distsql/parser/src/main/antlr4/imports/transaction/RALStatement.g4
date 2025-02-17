/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

grammar RALStatement;

import Keyword, Literals;

showTransactionRule
    : SHOW TRANSACTION RULE
    ;

alterTransactionRule
    : ALTER TRANSACTION RULE transactionRuleDefinition
    ;

transactionRuleDefinition
    : LP DEFAULT EQ defaultType (COMMA providerDefinition)?
    ;

providerDefinition
    : TYPE LP NAME EQ providerName (COMMA propertiesDefinition)? RP
    ;

defaultType
    : STRING | buildInDefaultTransactionType
    ;

buildInDefaultTransactionType
    : LOCAL | XA | BASE
    ;

providerName
    : STRING | buildInProviderTypeName
    ;

buildInProviderTypeName
    : ATOMIKOS | NARAYANA | BITRONIX
    ;

propertiesDefinition
    : PROPERTIES LP properties? RP
    ;

properties
    : property (COMMA property)*
    ;

property
    : key=STRING EQ value=STRING
    ;
