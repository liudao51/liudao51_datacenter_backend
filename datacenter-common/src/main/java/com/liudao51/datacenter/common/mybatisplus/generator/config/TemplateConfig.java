/*
 * Copyright (c) 2011-2020, hubin (jobob@qq.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.liudao51.datacenter.common.mybatisplus.generator.config;

/**
 * <p>
 * 模板路径配置项
 * </p>
 *
 * @author tzg hubin
 * @since 2017-06-17
 */
public class TemplateConfig {

    private String entity = ConstVal.TEMPLATE_ENTITY_JAVA;

    private String entityKt = ConstVal.TEMPLATE_ENTITY_KT;

    private String mapper = ConstVal.TEMPLATE_MAPPER;

    private String xml = ConstVal.TEMPLATE_XML;

    private String dao = ConstVal.TEMPLATE_DAO;

    private String daoImpl = ConstVal.TEMPLATE_DAO_IMPL;

    private String service = ConstVal.TEMPLATE_SERVICE;

    private String serviceImpl = ConstVal.TEMPLATE_SERVICE_IMPL;

    private String controller = ConstVal.TEMPLATE_CONTROLLER;

    private String controllerImpl = ConstVal.TEMPLATE_CONTROLLER_IMPL;

    public String getEntity(boolean kotlin) {
        return kotlin ? entityKt : entity;
    }

    public TemplateConfig setEntityKt(String entityKt) {
        this.entityKt = entityKt;
        return this;
    }

    public TemplateConfig setEntity(String entity) {
        this.entity = entity;
        return this;
    }

    public String getMapper() {
        return mapper;
    }

    public TemplateConfig setMapper(String mapper) {
        this.mapper = mapper;
        return this;
    }

    public String getXml() {
        return xml;
    }

    public TemplateConfig setXml(String xml) {
        this.xml = xml;
        return this;
    }

    public String getDao() {
        return dao;
    }

    public TemplateConfig setDao(String dao) {
        this.dao = dao;
        return this;
    }

    public String getDaoImpl() {
        return daoImpl;
    }

    public TemplateConfig setDaoImpl(String daoImpl) {
        this.daoImpl = daoImpl;
        return this;
    }

    public String getService() {
        return service;
    }

    public TemplateConfig setService(String service) {
        this.service = service;
        return this;
    }

    public String getServiceImpl() {
        return serviceImpl;
    }

    public TemplateConfig setServiceImpl(String serviceImpl) {
        this.serviceImpl = serviceImpl;
        return this;
    }

    public String getController() {
        return controller;
    }

    public TemplateConfig setController(String controller) {
        this.controller = controller;
        return this;
    }

    public String getControllerImpl() {
        return controllerImpl;
    }

    public TemplateConfig setControllerImpl(String controllerImpl) {
        this.controllerImpl = controllerImpl;
        return this;
    }
}
