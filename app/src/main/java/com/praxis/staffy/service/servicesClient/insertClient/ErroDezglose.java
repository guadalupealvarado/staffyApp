package com.praxis.staffy.service.servicesClient.insertClient;

import com.google.gson.annotations.SerializedName;

public class ErroDezglose {

    @SerializedName("name")
    private String name;
    @SerializedName("length")
    private Integer length;
    @SerializedName("severity")
    private String severity;
    @SerializedName("code")
    private String code;
    @SerializedName("detail")
    private String detail;
    @SerializedName("where")
    private String where;
    @SerializedName("schema")
    private String schema;
    @SerializedName("table")
    private String table;
    @SerializedName("constraint")
    private String constraint;
    @SerializedName("file")
    private String file;
    @SerializedName("line")
    private String line;
    @SerializedName("routine")
    private String routine;

    /**
     * No args constructor for use in serialization
     *
     */
    public ErroDezglose() {
    }

    /**
     *
     * @param schema
     * @param detail
     * @param file
     * @param name
     * @param length
     * @param line
     * @param constraint
     * @param severity
     * @param routine
     * @param table
     * @param code
     * @param where
     */
    public ErroDezglose(String name, Integer length, String severity, String code, String detail, String where, String schema, String table, String constraint, String file, String line, String routine) {
        super();
        this.name = name;
        this.length = length;
        this.severity = severity;
        this.code = code;
        this.detail = detail;
        this.where = where;
        this.schema = schema;
        this.table = table;
        this.constraint = constraint;
        this.file = file;
        this.line = line;
        this.routine = routine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }

    public String getTable() {
        return table;
    }

    public void setTable(String table) {
        this.table = table;
    }

    public String getConstraint() {
        return constraint;
    }

    public void setConstraint(String constraint) {
        this.constraint = constraint;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getRoutine() {
        return routine;
    }

    public void setRoutine(String routine) {
        this.routine = routine;
    }

}
