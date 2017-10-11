=============================================================================================================================================
Three different ways to link a stylesheet to a component in wicket:
https://cwiki.apache.org/confluence/display/WICKET/Including+CSS+resources
=============================================================================================================================================
- SomePage1: css file linked via java:
// note the scope parameter = any class in corresponding package
response.render(CssHeaderItem.forReference(new CssResourceReference(WicketApplication.class, SOME_STYLE_SHEET_CSS)));
- SomePage2: css file linked via html using wicket tags:
<head>
    <wicket:head>
        <wicket:link>
            <link href="SomeStyleSheet.css" rel="stylesheet" type="text/css"/>
        </wicket:link>
    </wicket:head>
</head>
- SomePage3: css file linked via html by placing it in root of war
<head>
    <link href="RootStyleSheet.css" rel="stylesheet" type="text/css"/>
</head>