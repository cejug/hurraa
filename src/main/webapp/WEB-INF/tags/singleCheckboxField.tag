<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="cejug"%>
<%@ attribute name="name" required="true" %>
<%@ attribute name="value" required="false" %>

<label for="${name}"><fmt:message key="${name }" /></label>
<input type="checkbox" name="${name }" id="${name }" value="true" ${value == true ? 'checked="checked"' : '' } />
