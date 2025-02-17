+++
title = "Rules"
weight = 3
+++

## Background

This section describes how to configure the rules for ShardingSphere-Proxy.

## Parameters Explained

Rules configuration of ShardingSphere-Proxy is the same as that of ShardingSphere-JDBC.
For details, please refer to [ShardingSphere-JDBC Rules Configuration](/en/user-manual/shardingsphere-jdbc/yaml-config/rules/).

## Notice

Unlike ShardingSphere-JDBC, the following rules need to be configured in `server.yaml` of ShardingSphere-Proxy:

* [SQL Parsing](/en/user-manual/shardingsphere-jdbc/yaml-config/rules/sql-parser/)
```yaml
sqlParser:
  sqlCommentParseEnabled: true
  sqlStatementCache:
    initialCapacity: 2000
    maximumSize: 65535
  parseTreeCache:
    initialCapacity: 128
    maximumSize: 1024
```
* [Distributed Operations](/en/user-manual/shardingsphere-jdbc/yaml-config/rules/transaction/)
```yaml
transaction:
  defaultType: XA
  providerType: Atomikos
```
* [SQL Translator](/cn/user-manual/shardingsphere-jdbc/yaml-config/rules/sql-translator/)
```yaml
sqlTranslator:
  type:
  useOriginalSQLWhenTranslatingFailed:
```
