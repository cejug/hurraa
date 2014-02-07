<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cejug"%>
<%@ attribute name="name" required="true" %>
<%@ attribute name="value" required="false" %>

<div class="form-group">
  <div class="col-sm-offset-2 col-sm-10">
    <div class="checkbox">
      <label>
        <input type="checkbox" name="${name}" id="${name}" value="true" ${value == true ? 'checked="checked"' : ''} /> <fmt:message key="${name}" />
      </label>
    </div>
  </div>
</div>