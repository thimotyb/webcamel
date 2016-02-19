<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:web="http://sisal/camelweb"
    version="1.0">
    <xsl:output method="text" encoding="ISO-8859-1" />
    <xsl:variable name="newline" select="'&#xA;'"/>
    <xsl:template match="web:customer">
        <xsl:for-each select="/">
            <xsl:value-of select="arg0" />
            <xsl:text>,</xsl:text>
            <xsl:value-of select="arg1" />
            <xsl:text>,</xsl:text>
            <xsl:value-of select="arg2" />
            <xsl:value-of select="$newline" />
        </xsl:for-each>
    </xsl:template>
</xsl:stylesheet>