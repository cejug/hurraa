<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ attribute name="name" required="true"%>
<%@ attribute name="value" required="false"%>

<label for="${name}"> <fmt:message key="${name }" />
</label>
<input name="${name }" id="${name }" value="${value }" />