// Generated from c:/Users/Guany/Documents/GitHub/FYP2023/Main/antlr_grammar/JavaParser.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class JavaParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		ABSTRACT=1, ASSERT=2, BOOLEAN=3, BREAK=4, BYTE=5, CASE=6, CATCH=7, CHAR=8, 
		CLASS=9, CONST=10, CONTINUE=11, DEFAULT=12, DO=13, DOUBLE=14, ELSE=15, 
		ENUM=16, EXTENDS=17, FINAL=18, FINALLY=19, FLOAT=20, FOR=21, IF=22, GOTO=23, 
		IMPLEMENTS=24, IMPORT=25, INSTANCEOF=26, INT=27, INTERFACE=28, LONG=29, 
		NATIVE=30, NEW=31, PACKAGE=32, PRIVATE=33, PROTECTED=34, PUBLIC=35, RETURN=36, 
		SHORT=37, STATIC=38, STRICTFP=39, SUPER=40, SWITCH=41, SYNCHRONIZED=42, 
		THIS=43, THROW=44, THROWS=45, TRANSIENT=46, TRY=47, VOID=48, VOLATILE=49, 
		WHILE=50, MODULE=51, OPEN=52, REQUIRES=53, EXPORTS=54, OPENS=55, TO=56, 
		USES=57, PROVIDES=58, WITH=59, TRANSITIVE=60, VAR=61, YIELD=62, RECORD=63, 
		SEALED=64, PERMITS=65, NON_SEALED=66, DECIMAL_LITERAL=67, HEX_LITERAL=68, 
		OCT_LITERAL=69, BINARY_LITERAL=70, FLOAT_LITERAL=71, HEX_FLOAT_LITERAL=72, 
		BOOL_LITERAL=73, CHAR_LITERAL=74, STRING_LITERAL=75, TEXT_BLOCK=76, NULL_LITERAL=77, 
		LPAREN=78, RPAREN=79, LBRACE=80, RBRACE=81, LBRACK=82, RBRACK=83, SEMI=84, 
		COMMA=85, DOT=86, ASSIGN=87, GT=88, LT=89, BANG=90, TILDE=91, QUESTION=92, 
		COLON=93, EQUAL=94, LE=95, GE=96, NOTEQUAL=97, AND=98, OR=99, INC=100, 
		DEC=101, ADD=102, SUB=103, MUL=104, DIV=105, BITAND=106, BITOR=107, CARET=108, 
		MOD=109, ADD_ASSIGN=110, SUB_ASSIGN=111, MUL_ASSIGN=112, DIV_ASSIGN=113, 
		AND_ASSIGN=114, OR_ASSIGN=115, XOR_ASSIGN=116, MOD_ASSIGN=117, LSHIFT_ASSIGN=118, 
		RSHIFT_ASSIGN=119, URSHIFT_ASSIGN=120, ARROW=121, COLONCOLON=122, AT=123, 
		ELLIPSIS=124, WS=125, JAVA_DOC_COMMENT=126, COMMENT=127, LINE_COMMENT=128, 
		LINE_SEPARATOR=129, IDENTIFIER=130;
	public static final int
		RULE_compilationUnit = 0, RULE_packageDeclaration = 1, RULE_importDeclaration = 2, 
		RULE_typeDeclaration = 3, RULE_modifier = 4, RULE_classOrInterfaceModifier = 5, 
		RULE_variableModifier = 6, RULE_classDeclaration = 7, RULE_typeParameters = 8, 
		RULE_typeParameter = 9, RULE_typeBound = 10, RULE_enumDeclaration = 11, 
		RULE_enumConstants = 12, RULE_enumConstant = 13, RULE_enumBodyDeclarations = 14, 
		RULE_interfaceDeclaration = 15, RULE_classBody = 16, RULE_interfaceBody = 17, 
		RULE_classBodyDeclaration = 18, RULE_memberDeclaration = 19, RULE_methodDeclaration = 20, 
		RULE_methodBody = 21, RULE_typeTypeOrVoid = 22, RULE_genericMethodDeclaration = 23, 
		RULE_genericConstructorDeclaration = 24, RULE_constructorDeclaration = 25, 
		RULE_compactConstructorDeclaration = 26, RULE_fieldDeclaration = 27, RULE_interfaceBodyDeclaration = 28, 
		RULE_interfaceMemberDeclaration = 29, RULE_constDeclaration = 30, RULE_constantDeclarator = 31, 
		RULE_interfaceMethodDeclaration = 32, RULE_interfaceMethodModifier = 33, 
		RULE_genericInterfaceMethodDeclaration = 34, RULE_interfaceCommonBodyDeclaration = 35, 
		RULE_variableDeclarators = 36, RULE_variableDeclarator = 37, RULE_variableDeclaratorId = 38, 
		RULE_variableInitializer = 39, RULE_arrayInitializer = 40, RULE_classOrInterfaceType = 41, 
		RULE_typeArgument = 42, RULE_qualifiedNameList = 43, RULE_formalParameters = 44, 
		RULE_receiverParameter = 45, RULE_formalParameterList = 46, RULE_formalParameter = 47, 
		RULE_lastFormalParameter = 48, RULE_lambdaLVTIList = 49, RULE_lambdaLVTIParameter = 50, 
		RULE_qualifiedName = 51, RULE_literal = 52, RULE_integerLiteral = 53, 
		RULE_floatLiteral = 54, RULE_altAnnotationQualifiedName = 55, RULE_annotation = 56, 
		RULE_elementValuePairs = 57, RULE_elementValuePair = 58, RULE_elementValue = 59, 
		RULE_elementValueArrayInitializer = 60, RULE_annotationTypeDeclaration = 61, 
		RULE_annotationTypeBody = 62, RULE_annotationTypeElementDeclaration = 63, 
		RULE_annotationTypeElementRest = 64, RULE_annotationMethodOrConstantRest = 65, 
		RULE_annotationMethodRest = 66, RULE_annotationConstantRest = 67, RULE_defaultValue = 68, 
		RULE_moduleDeclaration = 69, RULE_moduleBody = 70, RULE_moduleDirective = 71, 
		RULE_requiresModifier = 72, RULE_block = 73, RULE_blockStatement = 74, 
		RULE_localVariableDeclaration = 75, RULE_identifier = 76, RULE_typeIdentifier = 77, 
		RULE_localTypeDeclaration = 78, RULE_statement = 79, RULE_catchClause = 80, 
		RULE_catchType = 81, RULE_finallyBlock = 82, RULE_resourceSpecification = 83, 
		RULE_resources = 84, RULE_resource = 85, RULE_switchBlockStatementGroup = 86, 
		RULE_switchLabel = 87, RULE_forControl = 88, RULE_forInit = 89, RULE_enhancedForControl = 90, 
		RULE_parExpression = 91, RULE_expressionList = 92, RULE_methodCall = 93, 
		RULE_expression = 94, RULE_pattern = 95, RULE_lambdaExpression = 96, RULE_lambdaParameters = 97, 
		RULE_lambdaBody = 98, RULE_primary = 99, RULE_switchExpression = 100, 
		RULE_switchLabeledRule = 101, RULE_guardedPattern = 102, RULE_switchRuleOutcome = 103, 
		RULE_classType = 104, RULE_creator = 105, RULE_createdName = 106, RULE_innerCreator = 107, 
		RULE_arrayCreatorRest = 108, RULE_classCreatorRest = 109, RULE_explicitGenericInvocation = 110, 
		RULE_typeArgumentsOrDiamond = 111, RULE_nonWildcardTypeArgumentsOrDiamond = 112, 
		RULE_nonWildcardTypeArguments = 113, RULE_typeList = 114, RULE_typeType = 115, 
		RULE_primitiveType = 116, RULE_typeArguments = 117, RULE_superSuffix = 118, 
		RULE_explicitGenericInvocationSuffix = 119, RULE_arguments = 120;
	private static String[] makeRuleNames() {
		return new String[] {
			"compilationUnit", "packageDeclaration", "importDeclaration", "typeDeclaration", 
			"modifier", "classOrInterfaceModifier", "variableModifier", "classDeclaration", 
			"typeParameters", "typeParameter", "typeBound", "enumDeclaration", "enumConstants", 
			"enumConstant", "enumBodyDeclarations", "interfaceDeclaration", "classBody", 
			"interfaceBody", "classBodyDeclaration", "memberDeclaration", "methodDeclaration", 
			"methodBody", "typeTypeOrVoid", "genericMethodDeclaration", "genericConstructorDeclaration", 
			"constructorDeclaration", "compactConstructorDeclaration", "fieldDeclaration", 
			"interfaceBodyDeclaration", "interfaceMemberDeclaration", "constDeclaration", 
			"constantDeclarator", "interfaceMethodDeclaration", "interfaceMethodModifier", 
			"genericInterfaceMethodDeclaration", "interfaceCommonBodyDeclaration", 
			"variableDeclarators", "variableDeclarator", "variableDeclaratorId", 
			"variableInitializer", "arrayInitializer", "classOrInterfaceType", "typeArgument", 
			"qualifiedNameList", "formalParameters", "receiverParameter", "formalParameterList", 
			"formalParameter", "lastFormalParameter", "lambdaLVTIList", "lambdaLVTIParameter", 
			"qualifiedName", "literal", "integerLiteral", "floatLiteral", "altAnnotationQualifiedName", 
			"annotation", "elementValuePairs", "elementValuePair", "elementValue", 
			"elementValueArrayInitializer", "annotationTypeDeclaration", "annotationTypeBody", 
			"annotationTypeElementDeclaration", "annotationTypeElementRest", "annotationMethodOrConstantRest", 
			"annotationMethodRest", "annotationConstantRest", "defaultValue", "moduleDeclaration", 
			"moduleBody", "moduleDirective", "requiresModifier", "block", "blockStatement", 
			"localVariableDeclaration", "identifier", "typeIdentifier", "localTypeDeclaration", 
			"statement", "catchClause", "catchType", "finallyBlock", "resourceSpecification", 
			"resources", "resource", "switchBlockStatementGroup", "switchLabel", 
			"forControl", "forInit", "enhancedForControl", "parExpression", "expressionList", 
			"methodCall", "expression", "pattern", "lambdaExpression", "lambdaParameters", 
			"lambdaBody", "primary", "switchExpression", "switchLabeledRule", "guardedPattern", 
			"switchRuleOutcome", "classType", "creator", "createdName", "innerCreator", 
			"arrayCreatorRest", "classCreatorRest", "explicitGenericInvocation", 
			"typeArgumentsOrDiamond", "nonWildcardTypeArgumentsOrDiamond", "nonWildcardTypeArguments", 
			"typeList", "typeType", "primitiveType", "typeArguments", "superSuffix", 
			"explicitGenericInvocationSuffix", "arguments"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'abstract'", "'assert'", "'boolean'", "'break'", "'byte'", "'case'", 
			"'catch'", "'char'", "'class'", "'const'", "'continue'", "'default'", 
			"'do'", "'double'", "'else'", "'enum'", "'extends'", "'final'", "'finally'", 
			"'float'", "'for'", "'if'", "'goto'", "'implements'", "'import'", "'instanceof'", 
			"'int'", "'interface'", "'long'", "'native'", "'new'", "'package'", "'private'", 
			"'protected'", "'public'", "'return'", "'short'", "'static'", "'strictfp'", 
			"'super'", "'switch'", "'synchronized'", "'this'", "'throw'", "'throws'", 
			"'transient'", "'try'", "'void'", "'volatile'", "'while'", "'module'", 
			"'open'", "'requires'", "'exports'", "'opens'", "'to'", "'uses'", "'provides'", 
			"'with'", "'transitive'", "'var'", "'yield'", "'record'", "'sealed'", 
			"'permits'", "'non-sealed'", null, null, null, null, null, null, null, 
			null, null, null, "'null'", "'('", "')'", "'{'", "'}'", "'['", "']'", 
			"';'", "','", "'.'", "'='", "'>'", "'<'", "'!'", "'~'", "'?'", "':'", 
			"'=='", "'<='", "'>='", "'!='", "'&&'", "'||'", "'++'", "'--'", "'+'", 
			"'-'", "'*'", "'/'", "'&'", "'|'", "'^'", "'%'", "'+='", "'-='", "'*='", 
			"'/='", "'&='", "'|='", "'^='", "'%='", "'<<='", "'>>='", "'>>>='", "'->'", 
			"'::'", "'@'", "'...'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "ABSTRACT", "ASSERT", "BOOLEAN", "BREAK", "BYTE", "CASE", "CATCH", 
			"CHAR", "CLASS", "CONST", "CONTINUE", "DEFAULT", "DO", "DOUBLE", "ELSE", 
			"ENUM", "EXTENDS", "FINAL", "FINALLY", "FLOAT", "FOR", "IF", "GOTO", 
			"IMPLEMENTS", "IMPORT", "INSTANCEOF", "INT", "INTERFACE", "LONG", "NATIVE", 
			"NEW", "PACKAGE", "PRIVATE", "PROTECTED", "PUBLIC", "RETURN", "SHORT", 
			"STATIC", "STRICTFP", "SUPER", "SWITCH", "SYNCHRONIZED", "THIS", "THROW", 
			"THROWS", "TRANSIENT", "TRY", "VOID", "VOLATILE", "WHILE", "MODULE", 
			"OPEN", "REQUIRES", "EXPORTS", "OPENS", "TO", "USES", "PROVIDES", "WITH", 
			"TRANSITIVE", "VAR", "YIELD", "RECORD", "SEALED", "PERMITS", "NON_SEALED", 
			"DECIMAL_LITERAL", "HEX_LITERAL", "OCT_LITERAL", "BINARY_LITERAL", "FLOAT_LITERAL", 
			"HEX_FLOAT_LITERAL", "BOOL_LITERAL", "CHAR_LITERAL", "STRING_LITERAL", 
			"TEXT_BLOCK", "NULL_LITERAL", "LPAREN", "RPAREN", "LBRACE", "RBRACE", 
			"LBRACK", "RBRACK", "SEMI", "COMMA", "DOT", "ASSIGN", "GT", "LT", "BANG", 
			"TILDE", "QUESTION", "COLON", "EQUAL", "LE", "GE", "NOTEQUAL", "AND", 
			"OR", "INC", "DEC", "ADD", "SUB", "MUL", "DIV", "BITAND", "BITOR", "CARET", 
			"MOD", "ADD_ASSIGN", "SUB_ASSIGN", "MUL_ASSIGN", "DIV_ASSIGN", "AND_ASSIGN", 
			"OR_ASSIGN", "XOR_ASSIGN", "MOD_ASSIGN", "LSHIFT_ASSIGN", "RSHIFT_ASSIGN", 
			"URSHIFT_ASSIGN", "ARROW", "COLONCOLON", "AT", "ELLIPSIS", "WS", "JAVA_DOC_COMMENT", 
			"COMMENT", "LINE_COMMENT", "LINE_SEPARATOR", "IDENTIFIER"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "JavaParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public JavaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CompilationUnitContext extends ParserRuleContext {
		public PackageDeclarationContext packageDeclaration() {
			return getRuleContext(PackageDeclarationContext.class,0);
		}
		public List<ImportDeclarationContext> importDeclaration() {
			return getRuleContexts(ImportDeclarationContext.class);
		}
		public ImportDeclarationContext importDeclaration(int i) {
			return getRuleContext(ImportDeclarationContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(JavaParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(JavaParser.SEMI, i);
		}
		public List<TypeDeclarationContext> typeDeclaration() {
			return getRuleContexts(TypeDeclarationContext.class);
		}
		public TypeDeclarationContext typeDeclaration(int i) {
			return getRuleContext(TypeDeclarationContext.class,i);
		}
		public ModuleDeclarationContext moduleDeclaration() {
			return getRuleContext(ModuleDeclarationContext.class,0);
		}
		public TerminalNode EOF() { return getToken(JavaParser.EOF, 0); }
		public CompilationUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compilationUnit; }
	}

	public final CompilationUnitContext compilationUnit() throws RecognitionException {
		CompilationUnitContext _localctx = new CompilationUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_compilationUnit);
		int _la;
		try {
			int _alt;
			setState(262);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(243);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(242);
					packageDeclaration();
					}
					break;
				}
				setState(249);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						setState(247);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case IMPORT:
							{
							setState(245);
							importDeclaration();
							}
							break;
						case SEMI:
							{
							setState(246);
							match(SEMI);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						} 
					}
					setState(251);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				}
				setState(256);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -2250914781658622L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 576460752304472067L) != 0) || _la==IDENTIFIER) {
					{
					setState(254);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case ABSTRACT:
					case CLASS:
					case ENUM:
					case FINAL:
					case INTERFACE:
					case PRIVATE:
					case PROTECTED:
					case PUBLIC:
					case STATIC:
					case STRICTFP:
					case MODULE:
					case OPEN:
					case REQUIRES:
					case EXPORTS:
					case OPENS:
					case TO:
					case USES:
					case PROVIDES:
					case WITH:
					case TRANSITIVE:
					case VAR:
					case YIELD:
					case RECORD:
					case SEALED:
					case PERMITS:
					case AT:
					case IDENTIFIER:
						{
						setState(252);
						typeDeclaration();
						}
						break;
					case SEMI:
						{
						setState(253);
						match(SEMI);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(258);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(259);
				moduleDeclaration();
				setState(260);
				match(EOF);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PackageDeclarationContext extends ParserRuleContext {
		public TerminalNode PACKAGE() { return getToken(JavaParser.PACKAGE, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(JavaParser.SEMI, 0); }
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public PackageDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_packageDeclaration; }
	}

	public final PackageDeclarationContext packageDeclaration() throws RecognitionException {
		PackageDeclarationContext _localctx = new PackageDeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_packageDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(267);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 51)) & ~0x3f) == 0 && ((1L << (_la - 51)) & 32767L) != 0) || _la==AT || _la==IDENTIFIER) {
				{
				{
				setState(264);
				annotation();
				}
				}
				setState(269);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(270);
			match(PACKAGE);
			setState(271);
			qualifiedName();
			setState(272);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ImportDeclarationContext extends ParserRuleContext {
		public TerminalNode IMPORT() { return getToken(JavaParser.IMPORT, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(JavaParser.SEMI, 0); }
		public TerminalNode STATIC() { return getToken(JavaParser.STATIC, 0); }
		public TerminalNode DOT() { return getToken(JavaParser.DOT, 0); }
		public TerminalNode MUL() { return getToken(JavaParser.MUL, 0); }
		public ImportDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importDeclaration; }
	}

	public final ImportDeclarationContext importDeclaration() throws RecognitionException {
		ImportDeclarationContext _localctx = new ImportDeclarationContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_importDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
			match(IMPORT);
			setState(276);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==STATIC) {
				{
				setState(275);
				match(STATIC);
				}
			}

			setState(278);
			qualifiedName();
			setState(281);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DOT) {
				{
				setState(279);
				match(DOT);
				setState(280);
				match(MUL);
				}
			}

			setState(283);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeDeclarationContext extends ParserRuleContext {
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public EnumDeclarationContext enumDeclaration() {
			return getRuleContext(EnumDeclarationContext.class,0);
		}
		public InterfaceDeclarationContext interfaceDeclaration() {
			return getRuleContext(InterfaceDeclarationContext.class,0);
		}
		public AnnotationTypeDeclarationContext annotationTypeDeclaration() {
			return getRuleContext(AnnotationTypeDeclarationContext.class,0);
		}
		public List<ClassOrInterfaceModifierContext> classOrInterfaceModifier() {
			return getRuleContexts(ClassOrInterfaceModifierContext.class);
		}
		public ClassOrInterfaceModifierContext classOrInterfaceModifier(int i) {
			return getRuleContext(ClassOrInterfaceModifierContext.class,i);
		}
		public TypeDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDeclaration; }
	}

	public final TypeDeclarationContext typeDeclaration() throws RecognitionException {
		TypeDeclarationContext _localctx = new TypeDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_typeDeclaration);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(288);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(285);
					classOrInterfaceModifier();
					}
					} 
				}
				setState(290);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			setState(295);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLASS:
				{
				setState(291);
				classDeclaration();
				}
				break;
			case ENUM:
				{
				setState(292);
				enumDeclaration();
				}
				break;
			case INTERFACE:
				{
				setState(293);
				interfaceDeclaration();
				}
				break;
			case AT:
				{
				setState(294);
				annotationTypeDeclaration();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ModifierContext extends ParserRuleContext {
		public ClassOrInterfaceModifierContext classOrInterfaceModifier() {
			return getRuleContext(ClassOrInterfaceModifierContext.class,0);
		}
		public TerminalNode NATIVE() { return getToken(JavaParser.NATIVE, 0); }
		public TerminalNode SYNCHRONIZED() { return getToken(JavaParser.SYNCHRONIZED, 0); }
		public TerminalNode TRANSIENT() { return getToken(JavaParser.TRANSIENT, 0); }
		public TerminalNode VOLATILE() { return getToken(JavaParser.VOLATILE, 0); }
		public ModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifier; }
	}

	public final ModifierContext modifier() throws RecognitionException {
		ModifierContext _localctx = new ModifierContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_modifier);
		try {
			setState(302);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ABSTRACT:
			case FINAL:
			case PRIVATE:
			case PROTECTED:
			case PUBLIC:
			case STATIC:
			case STRICTFP:
			case MODULE:
			case OPEN:
			case REQUIRES:
			case EXPORTS:
			case OPENS:
			case TO:
			case USES:
			case PROVIDES:
			case WITH:
			case TRANSITIVE:
			case VAR:
			case YIELD:
			case RECORD:
			case SEALED:
			case PERMITS:
			case AT:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(297);
				classOrInterfaceModifier();
				}
				break;
			case NATIVE:
				enterOuterAlt(_localctx, 2);
				{
				setState(298);
				match(NATIVE);
				}
				break;
			case SYNCHRONIZED:
				enterOuterAlt(_localctx, 3);
				{
				setState(299);
				match(SYNCHRONIZED);
				}
				break;
			case TRANSIENT:
				enterOuterAlt(_localctx, 4);
				{
				setState(300);
				match(TRANSIENT);
				}
				break;
			case VOLATILE:
				enterOuterAlt(_localctx, 5);
				{
				setState(301);
				match(VOLATILE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassOrInterfaceModifierContext extends ParserRuleContext {
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public TerminalNode PUBLIC() { return getToken(JavaParser.PUBLIC, 0); }
		public TerminalNode PROTECTED() { return getToken(JavaParser.PROTECTED, 0); }
		public TerminalNode PRIVATE() { return getToken(JavaParser.PRIVATE, 0); }
		public TerminalNode STATIC() { return getToken(JavaParser.STATIC, 0); }
		public TerminalNode ABSTRACT() { return getToken(JavaParser.ABSTRACT, 0); }
		public TerminalNode FINAL() { return getToken(JavaParser.FINAL, 0); }
		public TerminalNode STRICTFP() { return getToken(JavaParser.STRICTFP, 0); }
		public ClassOrInterfaceModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classOrInterfaceModifier; }
	}

	public final ClassOrInterfaceModifierContext classOrInterfaceModifier() throws RecognitionException {
		ClassOrInterfaceModifierContext _localctx = new ClassOrInterfaceModifierContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_classOrInterfaceModifier);
		try {
			setState(312);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MODULE:
			case OPEN:
			case REQUIRES:
			case EXPORTS:
			case OPENS:
			case TO:
			case USES:
			case PROVIDES:
			case WITH:
			case TRANSITIVE:
			case VAR:
			case YIELD:
			case RECORD:
			case SEALED:
			case PERMITS:
			case AT:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(304);
				annotation();
				}
				break;
			case PUBLIC:
				enterOuterAlt(_localctx, 2);
				{
				setState(305);
				match(PUBLIC);
				}
				break;
			case PROTECTED:
				enterOuterAlt(_localctx, 3);
				{
				setState(306);
				match(PROTECTED);
				}
				break;
			case PRIVATE:
				enterOuterAlt(_localctx, 4);
				{
				setState(307);
				match(PRIVATE);
				}
				break;
			case STATIC:
				enterOuterAlt(_localctx, 5);
				{
				setState(308);
				match(STATIC);
				}
				break;
			case ABSTRACT:
				enterOuterAlt(_localctx, 6);
				{
				setState(309);
				match(ABSTRACT);
				}
				break;
			case FINAL:
				enterOuterAlt(_localctx, 7);
				{
				setState(310);
				match(FINAL);
				}
				break;
			case STRICTFP:
				enterOuterAlt(_localctx, 8);
				{
				setState(311);
				match(STRICTFP);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableModifierContext extends ParserRuleContext {
		public TerminalNode FINAL() { return getToken(JavaParser.FINAL, 0); }
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public VariableModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableModifier; }
	}

	public final VariableModifierContext variableModifier() throws RecognitionException {
		VariableModifierContext _localctx = new VariableModifierContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_variableModifier);
		try {
			setState(316);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FINAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(314);
				match(FINAL);
				}
				break;
			case MODULE:
			case OPEN:
			case REQUIRES:
			case EXPORTS:
			case OPENS:
			case TO:
			case USES:
			case PROVIDES:
			case WITH:
			case TRANSITIVE:
			case VAR:
			case YIELD:
			case RECORD:
			case SEALED:
			case PERMITS:
			case AT:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(315);
				annotation();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassDeclarationContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(JavaParser.CLASS, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public TerminalNode EXTENDS() { return getToken(JavaParser.EXTENDS, 0); }
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public TerminalNode IMPLEMENTS() { return getToken(JavaParser.IMPLEMENTS, 0); }
		public TypeListContext typeList() {
			return getRuleContext(TypeListContext.class,0);
		}
		public ClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclaration; }
	}

	public final ClassDeclarationContext classDeclaration() throws RecognitionException {
		ClassDeclarationContext _localctx = new ClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_classDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(318);
			match(CLASS);
			setState(319);
			identifier();
			setState(321);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(320);
				typeParameters();
				}
			}

			setState(325);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(323);
				match(EXTENDS);
				setState(324);
				typeType();
				}
			}

			setState(329);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IMPLEMENTS) {
				{
				setState(327);
				match(IMPLEMENTS);
				setState(328);
				typeList();
				}
			}

			setState(331);
			classBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeParametersContext extends ParserRuleContext {
		public TerminalNode LT() { return getToken(JavaParser.LT, 0); }
		public List<TypeParameterContext> typeParameter() {
			return getRuleContexts(TypeParameterContext.class);
		}
		public TypeParameterContext typeParameter(int i) {
			return getRuleContext(TypeParameterContext.class,i);
		}
		public TerminalNode GT() { return getToken(JavaParser.GT, 0); }
		public List<TerminalNode> COMMA() { return getTokens(JavaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JavaParser.COMMA, i);
		}
		public TypeParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameters; }
	}

	public final TypeParametersContext typeParameters() throws RecognitionException {
		TypeParametersContext _localctx = new TypeParametersContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_typeParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(333);
			match(LT);
			setState(334);
			typeParameter();
			setState(339);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(335);
				match(COMMA);
				setState(336);
				typeParameter();
				}
				}
				setState(341);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(342);
			match(GT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeParameterContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public TerminalNode EXTENDS() { return getToken(JavaParser.EXTENDS, 0); }
		public TypeBoundContext typeBound() {
			return getRuleContext(TypeBoundContext.class,0);
		}
		public TypeParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameter; }
	}

	public final TypeParameterContext typeParameter() throws RecognitionException {
		TypeParameterContext _localctx = new TypeParameterContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_typeParameter);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(347);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(344);
					annotation();
					}
					} 
				}
				setState(349);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			}
			setState(350);
			identifier();
			setState(359);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(351);
				match(EXTENDS);
				setState(355);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(352);
						annotation();
						}
						} 
					}
					setState(357);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
				}
				setState(358);
				typeBound();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeBoundContext extends ParserRuleContext {
		public List<TypeTypeContext> typeType() {
			return getRuleContexts(TypeTypeContext.class);
		}
		public TypeTypeContext typeType(int i) {
			return getRuleContext(TypeTypeContext.class,i);
		}
		public List<TerminalNode> BITAND() { return getTokens(JavaParser.BITAND); }
		public TerminalNode BITAND(int i) {
			return getToken(JavaParser.BITAND, i);
		}
		public TypeBoundContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeBound; }
	}

	public final TypeBoundContext typeBound() throws RecognitionException {
		TypeBoundContext _localctx = new TypeBoundContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_typeBound);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(361);
			typeType();
			setState(366);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BITAND) {
				{
				{
				setState(362);
				match(BITAND);
				setState(363);
				typeType();
				}
				}
				setState(368);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EnumDeclarationContext extends ParserRuleContext {
		public TerminalNode ENUM() { return getToken(JavaParser.ENUM, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LBRACE() { return getToken(JavaParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(JavaParser.RBRACE, 0); }
		public TerminalNode IMPLEMENTS() { return getToken(JavaParser.IMPLEMENTS, 0); }
		public TypeListContext typeList() {
			return getRuleContext(TypeListContext.class,0);
		}
		public EnumConstantsContext enumConstants() {
			return getRuleContext(EnumConstantsContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(JavaParser.COMMA, 0); }
		public EnumBodyDeclarationsContext enumBodyDeclarations() {
			return getRuleContext(EnumBodyDeclarationsContext.class,0);
		}
		public EnumDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumDeclaration; }
	}

	public final EnumDeclarationContext enumDeclaration() throws RecognitionException {
		EnumDeclarationContext _localctx = new EnumDeclarationContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_enumDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(369);
			match(ENUM);
			setState(370);
			identifier();
			setState(373);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IMPLEMENTS) {
				{
				setState(371);
				match(IMPLEMENTS);
				setState(372);
				typeList();
				}
			}

			setState(375);
			match(LBRACE);
			setState(377);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 51)) & ~0x3f) == 0 && ((1L << (_la - 51)) & 32767L) != 0) || _la==AT || _la==IDENTIFIER) {
				{
				setState(376);
				enumConstants();
				}
			}

			setState(380);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(379);
				match(COMMA);
				}
			}

			setState(383);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMI) {
				{
				setState(382);
				enumBodyDeclarations();
				}
			}

			setState(385);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EnumConstantsContext extends ParserRuleContext {
		public List<EnumConstantContext> enumConstant() {
			return getRuleContexts(EnumConstantContext.class);
		}
		public EnumConstantContext enumConstant(int i) {
			return getRuleContext(EnumConstantContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(JavaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JavaParser.COMMA, i);
		}
		public EnumConstantsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumConstants; }
	}

	public final EnumConstantsContext enumConstants() throws RecognitionException {
		EnumConstantsContext _localctx = new EnumConstantsContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_enumConstants);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(387);
			enumConstant();
			setState(392);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(388);
					match(COMMA);
					setState(389);
					enumConstant();
					}
					} 
				}
				setState(394);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EnumConstantContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public EnumConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumConstant; }
	}

	public final EnumConstantContext enumConstant() throws RecognitionException {
		EnumConstantContext _localctx = new EnumConstantContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_enumConstant);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(398);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(395);
					annotation();
					}
					} 
				}
				setState(400);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			}
			setState(401);
			identifier();
			setState(403);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(402);
				arguments();
				}
			}

			setState(406);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LBRACE) {
				{
				setState(405);
				classBody();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EnumBodyDeclarationsContext extends ParserRuleContext {
		public TerminalNode SEMI() { return getToken(JavaParser.SEMI, 0); }
		public List<ClassBodyDeclarationContext> classBodyDeclaration() {
			return getRuleContexts(ClassBodyDeclarationContext.class);
		}
		public ClassBodyDeclarationContext classBodyDeclaration(int i) {
			return getRuleContext(ClassBodyDeclarationContext.class,i);
		}
		public EnumBodyDeclarationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumBodyDeclarations; }
	}

	public final EnumBodyDeclarationsContext enumBodyDeclarations() throws RecognitionException {
		EnumBodyDeclarationsContext _localctx = new EnumBodyDeclarationsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_enumBodyDeclarations);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(408);
			match(SEMI);
			setState(412);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -1331583875988694L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 576460752338092035L) != 0) || _la==IDENTIFIER) {
				{
				{
				setState(409);
				classBodyDeclaration();
				}
				}
				setState(414);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InterfaceDeclarationContext extends ParserRuleContext {
		public TerminalNode INTERFACE() { return getToken(JavaParser.INTERFACE, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public InterfaceBodyContext interfaceBody() {
			return getRuleContext(InterfaceBodyContext.class,0);
		}
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public TerminalNode EXTENDS() { return getToken(JavaParser.EXTENDS, 0); }
		public List<TypeListContext> typeList() {
			return getRuleContexts(TypeListContext.class);
		}
		public TypeListContext typeList(int i) {
			return getRuleContext(TypeListContext.class,i);
		}
		public TerminalNode PERMITS() { return getToken(JavaParser.PERMITS, 0); }
		public InterfaceDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceDeclaration; }
	}

	public final InterfaceDeclarationContext interfaceDeclaration() throws RecognitionException {
		InterfaceDeclarationContext _localctx = new InterfaceDeclarationContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_interfaceDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(415);
			match(INTERFACE);
			setState(416);
			identifier();
			setState(418);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(417);
				typeParameters();
				}
			}

			setState(422);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==EXTENDS) {
				{
				setState(420);
				match(EXTENDS);
				setState(421);
				typeList();
				}
			}

			setState(426);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PERMITS) {
				{
				setState(424);
				match(PERMITS);
				setState(425);
				typeList();
				}
			}

			setState(428);
			interfaceBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassBodyContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(JavaParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(JavaParser.RBRACE, 0); }
		public List<ClassBodyDeclarationContext> classBodyDeclaration() {
			return getRuleContexts(ClassBodyDeclarationContext.class);
		}
		public ClassBodyDeclarationContext classBodyDeclaration(int i) {
			return getRuleContext(ClassBodyDeclarationContext.class,i);
		}
		public ClassBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBody; }
	}

	public final ClassBodyContext classBody() throws RecognitionException {
		ClassBodyContext _localctx = new ClassBodyContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_classBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(430);
			match(LBRACE);
			setState(434);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -1331583875988694L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 576460752338092035L) != 0) || _la==IDENTIFIER) {
				{
				{
				setState(431);
				classBodyDeclaration();
				}
				}
				setState(436);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(437);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InterfaceBodyContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(JavaParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(JavaParser.RBRACE, 0); }
		public List<InterfaceBodyDeclarationContext> interfaceBodyDeclaration() {
			return getRuleContexts(InterfaceBodyDeclarationContext.class);
		}
		public InterfaceBodyDeclarationContext interfaceBodyDeclaration(int i) {
			return getRuleContext(InterfaceBodyDeclarationContext.class,i);
		}
		public InterfaceBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceBody; }
	}

	public final InterfaceBodyContext interfaceBody() throws RecognitionException {
		InterfaceBodyContext _localctx = new InterfaceBodyContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_interfaceBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(439);
			match(LBRACE);
			setState(443);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -1331583875984598L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 576460752338026499L) != 0) || _la==IDENTIFIER) {
				{
				{
				setState(440);
				interfaceBodyDeclaration();
				}
				}
				setState(445);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(446);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassBodyDeclarationContext extends ParserRuleContext {
		public TerminalNode SEMI() { return getToken(JavaParser.SEMI, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode STATIC() { return getToken(JavaParser.STATIC, 0); }
		public MemberDeclarationContext memberDeclaration() {
			return getRuleContext(MemberDeclarationContext.class,0);
		}
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public ClassBodyDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBodyDeclaration; }
	}

	public final ClassBodyDeclarationContext classBodyDeclaration() throws RecognitionException {
		ClassBodyDeclarationContext _localctx = new ClassBodyDeclarationContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_classBodyDeclaration);
		int _la;
		try {
			int _alt;
			setState(460);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(448);
				match(SEMI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(450);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==STATIC) {
					{
					setState(449);
					match(STATIC);
					}
				}

				setState(452);
				block();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(456);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(453);
						modifier();
						}
						} 
					}
					setState(458);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,37,_ctx);
				}
				setState(459);
				memberDeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MemberDeclarationContext extends ParserRuleContext {
		public MethodDeclarationContext methodDeclaration() {
			return getRuleContext(MethodDeclarationContext.class,0);
		}
		public GenericMethodDeclarationContext genericMethodDeclaration() {
			return getRuleContext(GenericMethodDeclarationContext.class,0);
		}
		public FieldDeclarationContext fieldDeclaration() {
			return getRuleContext(FieldDeclarationContext.class,0);
		}
		public ConstructorDeclarationContext constructorDeclaration() {
			return getRuleContext(ConstructorDeclarationContext.class,0);
		}
		public GenericConstructorDeclarationContext genericConstructorDeclaration() {
			return getRuleContext(GenericConstructorDeclarationContext.class,0);
		}
		public InterfaceDeclarationContext interfaceDeclaration() {
			return getRuleContext(InterfaceDeclarationContext.class,0);
		}
		public AnnotationTypeDeclarationContext annotationTypeDeclaration() {
			return getRuleContext(AnnotationTypeDeclarationContext.class,0);
		}
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public EnumDeclarationContext enumDeclaration() {
			return getRuleContext(EnumDeclarationContext.class,0);
		}
		public MemberDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memberDeclaration; }
	}

	public final MemberDeclarationContext memberDeclaration() throws RecognitionException {
		MemberDeclarationContext _localctx = new MemberDeclarationContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_memberDeclaration);
		try {
			setState(471);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,39,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(462);
				methodDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(463);
				genericMethodDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(464);
				fieldDeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(465);
				constructorDeclaration();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(466);
				genericConstructorDeclaration();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(467);
				interfaceDeclaration();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(468);
				annotationTypeDeclaration();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(469);
				classDeclaration();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(470);
				enumDeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MethodDeclarationContext extends ParserRuleContext {
		public TypeTypeOrVoidContext typeTypeOrVoid() {
			return getRuleContext(TypeTypeOrVoidContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public FormalParametersContext formalParameters() {
			return getRuleContext(FormalParametersContext.class,0);
		}
		public MethodBodyContext methodBody() {
			return getRuleContext(MethodBodyContext.class,0);
		}
		public List<TerminalNode> LBRACK() { return getTokens(JavaParser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(JavaParser.LBRACK, i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(JavaParser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(JavaParser.RBRACK, i);
		}
		public TerminalNode THROWS() { return getToken(JavaParser.THROWS, 0); }
		public QualifiedNameListContext qualifiedNameList() {
			return getRuleContext(QualifiedNameListContext.class,0);
		}
		public MethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclaration; }
	}

	public final MethodDeclarationContext methodDeclaration() throws RecognitionException {
		MethodDeclarationContext _localctx = new MethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_methodDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(473);
			typeTypeOrVoid();
			setState(474);
			identifier();
			setState(475);
			formalParameters();
			setState(480);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACK) {
				{
				{
				setState(476);
				match(LBRACK);
				setState(477);
				match(RBRACK);
				}
				}
				setState(482);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(485);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==THROWS) {
				{
				setState(483);
				match(THROWS);
				setState(484);
				qualifiedNameList();
				}
			}

			setState(487);
			methodBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MethodBodyContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(JavaParser.SEMI, 0); }
		public MethodBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodBody; }
	}

	public final MethodBodyContext methodBody() throws RecognitionException {
		MethodBodyContext _localctx = new MethodBodyContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_methodBody);
		try {
			setState(491);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(489);
				block();
				}
				break;
			case SEMI:
				enterOuterAlt(_localctx, 2);
				{
				setState(490);
				match(SEMI);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeTypeOrVoidContext extends ParserRuleContext {
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public TerminalNode VOID() { return getToken(JavaParser.VOID, 0); }
		public TypeTypeOrVoidContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeTypeOrVoid; }
	}

	public final TypeTypeOrVoidContext typeTypeOrVoid() throws RecognitionException {
		TypeTypeOrVoidContext _localctx = new TypeTypeOrVoidContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_typeTypeOrVoid);
		try {
			setState(495);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
			case MODULE:
			case OPEN:
			case REQUIRES:
			case EXPORTS:
			case OPENS:
			case TO:
			case USES:
			case PROVIDES:
			case WITH:
			case TRANSITIVE:
			case VAR:
			case YIELD:
			case RECORD:
			case SEALED:
			case PERMITS:
			case AT:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(493);
				typeType();
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 2);
				{
				setState(494);
				match(VOID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GenericMethodDeclarationContext extends ParserRuleContext {
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public MethodDeclarationContext methodDeclaration() {
			return getRuleContext(MethodDeclarationContext.class,0);
		}
		public GenericMethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_genericMethodDeclaration; }
	}

	public final GenericMethodDeclarationContext genericMethodDeclaration() throws RecognitionException {
		GenericMethodDeclarationContext _localctx = new GenericMethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_genericMethodDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(497);
			typeParameters();
			setState(498);
			methodDeclaration();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GenericConstructorDeclarationContext extends ParserRuleContext {
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public ConstructorDeclarationContext constructorDeclaration() {
			return getRuleContext(ConstructorDeclarationContext.class,0);
		}
		public GenericConstructorDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_genericConstructorDeclaration; }
	}

	public final GenericConstructorDeclarationContext genericConstructorDeclaration() throws RecognitionException {
		GenericConstructorDeclarationContext _localctx = new GenericConstructorDeclarationContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_genericConstructorDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(500);
			typeParameters();
			setState(501);
			constructorDeclaration();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConstructorDeclarationContext extends ParserRuleContext {
		public BlockContext constructorBody;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public FormalParametersContext formalParameters() {
			return getRuleContext(FormalParametersContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode THROWS() { return getToken(JavaParser.THROWS, 0); }
		public QualifiedNameListContext qualifiedNameList() {
			return getRuleContext(QualifiedNameListContext.class,0);
		}
		public ConstructorDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructorDeclaration; }
	}

	public final ConstructorDeclarationContext constructorDeclaration() throws RecognitionException {
		ConstructorDeclarationContext _localctx = new ConstructorDeclarationContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_constructorDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(503);
			identifier();
			setState(504);
			formalParameters();
			setState(507);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==THROWS) {
				{
				setState(505);
				match(THROWS);
				setState(506);
				qualifiedNameList();
				}
			}

			setState(509);
			((ConstructorDeclarationContext)_localctx).constructorBody = block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CompactConstructorDeclarationContext extends ParserRuleContext {
		public BlockContext constructorBody;
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public CompactConstructorDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compactConstructorDeclaration; }
	}

	public final CompactConstructorDeclarationContext compactConstructorDeclaration() throws RecognitionException {
		CompactConstructorDeclarationContext _localctx = new CompactConstructorDeclarationContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_compactConstructorDeclaration);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(514);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(511);
					modifier();
					}
					} 
				}
				setState(516);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,45,_ctx);
			}
			setState(517);
			identifier();
			setState(518);
			((CompactConstructorDeclarationContext)_localctx).constructorBody = block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FieldDeclarationContext extends ParserRuleContext {
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public VariableDeclaratorsContext variableDeclarators() {
			return getRuleContext(VariableDeclaratorsContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(JavaParser.SEMI, 0); }
		public FieldDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDeclaration; }
	}

	public final FieldDeclarationContext fieldDeclaration() throws RecognitionException {
		FieldDeclarationContext _localctx = new FieldDeclarationContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_fieldDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(520);
			typeType();
			setState(521);
			variableDeclarators();
			setState(522);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InterfaceBodyDeclarationContext extends ParserRuleContext {
		public InterfaceMemberDeclarationContext interfaceMemberDeclaration() {
			return getRuleContext(InterfaceMemberDeclarationContext.class,0);
		}
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public TerminalNode SEMI() { return getToken(JavaParser.SEMI, 0); }
		public InterfaceBodyDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceBodyDeclaration; }
	}

	public final InterfaceBodyDeclarationContext interfaceBodyDeclaration() throws RecognitionException {
		InterfaceBodyDeclarationContext _localctx = new InterfaceBodyDeclarationContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_interfaceBodyDeclaration);
		try {
			int _alt;
			setState(532);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ABSTRACT:
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case CLASS:
			case DEFAULT:
			case DOUBLE:
			case ENUM:
			case FINAL:
			case FLOAT:
			case INT:
			case INTERFACE:
			case LONG:
			case NATIVE:
			case PRIVATE:
			case PROTECTED:
			case PUBLIC:
			case SHORT:
			case STATIC:
			case STRICTFP:
			case SYNCHRONIZED:
			case TRANSIENT:
			case VOID:
			case VOLATILE:
			case MODULE:
			case OPEN:
			case REQUIRES:
			case EXPORTS:
			case OPENS:
			case TO:
			case USES:
			case PROVIDES:
			case WITH:
			case TRANSITIVE:
			case VAR:
			case YIELD:
			case RECORD:
			case SEALED:
			case PERMITS:
			case LT:
			case AT:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(527);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(524);
						modifier();
						}
						} 
					}
					setState(529);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
				}
				setState(530);
				interfaceMemberDeclaration();
				}
				break;
			case SEMI:
				enterOuterAlt(_localctx, 2);
				{
				setState(531);
				match(SEMI);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InterfaceMemberDeclarationContext extends ParserRuleContext {
		public ConstDeclarationContext constDeclaration() {
			return getRuleContext(ConstDeclarationContext.class,0);
		}
		public InterfaceMethodDeclarationContext interfaceMethodDeclaration() {
			return getRuleContext(InterfaceMethodDeclarationContext.class,0);
		}
		public GenericInterfaceMethodDeclarationContext genericInterfaceMethodDeclaration() {
			return getRuleContext(GenericInterfaceMethodDeclarationContext.class,0);
		}
		public InterfaceDeclarationContext interfaceDeclaration() {
			return getRuleContext(InterfaceDeclarationContext.class,0);
		}
		public AnnotationTypeDeclarationContext annotationTypeDeclaration() {
			return getRuleContext(AnnotationTypeDeclarationContext.class,0);
		}
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public EnumDeclarationContext enumDeclaration() {
			return getRuleContext(EnumDeclarationContext.class,0);
		}
		public InterfaceMemberDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceMemberDeclaration; }
	}

	public final InterfaceMemberDeclarationContext interfaceMemberDeclaration() throws RecognitionException {
		InterfaceMemberDeclarationContext _localctx = new InterfaceMemberDeclarationContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_interfaceMemberDeclaration);
		try {
			setState(541);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,48,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(534);
				constDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(535);
				interfaceMethodDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(536);
				genericInterfaceMethodDeclaration();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(537);
				interfaceDeclaration();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(538);
				annotationTypeDeclaration();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(539);
				classDeclaration();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(540);
				enumDeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConstDeclarationContext extends ParserRuleContext {
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public List<ConstantDeclaratorContext> constantDeclarator() {
			return getRuleContexts(ConstantDeclaratorContext.class);
		}
		public ConstantDeclaratorContext constantDeclarator(int i) {
			return getRuleContext(ConstantDeclaratorContext.class,i);
		}
		public TerminalNode SEMI() { return getToken(JavaParser.SEMI, 0); }
		public List<TerminalNode> COMMA() { return getTokens(JavaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JavaParser.COMMA, i);
		}
		public ConstDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constDeclaration; }
	}

	public final ConstDeclarationContext constDeclaration() throws RecognitionException {
		ConstDeclarationContext _localctx = new ConstDeclarationContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_constDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(543);
			typeType();
			setState(544);
			constantDeclarator();
			setState(549);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(545);
				match(COMMA);
				setState(546);
				constantDeclarator();
				}
				}
				setState(551);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(552);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConstantDeclaratorContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(JavaParser.ASSIGN, 0); }
		public VariableInitializerContext variableInitializer() {
			return getRuleContext(VariableInitializerContext.class,0);
		}
		public List<TerminalNode> LBRACK() { return getTokens(JavaParser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(JavaParser.LBRACK, i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(JavaParser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(JavaParser.RBRACK, i);
		}
		public ConstantDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constantDeclarator; }
	}

	public final ConstantDeclaratorContext constantDeclarator() throws RecognitionException {
		ConstantDeclaratorContext _localctx = new ConstantDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_constantDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(554);
			identifier();
			setState(559);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACK) {
				{
				{
				setState(555);
				match(LBRACK);
				setState(556);
				match(RBRACK);
				}
				}
				setState(561);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(562);
			match(ASSIGN);
			setState(563);
			variableInitializer();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InterfaceMethodDeclarationContext extends ParserRuleContext {
		public InterfaceCommonBodyDeclarationContext interfaceCommonBodyDeclaration() {
			return getRuleContext(InterfaceCommonBodyDeclarationContext.class,0);
		}
		public List<InterfaceMethodModifierContext> interfaceMethodModifier() {
			return getRuleContexts(InterfaceMethodModifierContext.class);
		}
		public InterfaceMethodModifierContext interfaceMethodModifier(int i) {
			return getRuleContext(InterfaceMethodModifierContext.class,i);
		}
		public InterfaceMethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceMethodDeclaration; }
	}

	public final InterfaceMethodDeclarationContext interfaceMethodDeclaration() throws RecognitionException {
		InterfaceMethodDeclarationContext _localctx = new InterfaceMethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_interfaceMethodDeclaration);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(568);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(565);
					interfaceMethodModifier();
					}
					} 
				}
				setState(570);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
			}
			setState(571);
			interfaceCommonBodyDeclaration();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InterfaceMethodModifierContext extends ParserRuleContext {
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public TerminalNode PUBLIC() { return getToken(JavaParser.PUBLIC, 0); }
		public TerminalNode ABSTRACT() { return getToken(JavaParser.ABSTRACT, 0); }
		public TerminalNode DEFAULT() { return getToken(JavaParser.DEFAULT, 0); }
		public TerminalNode STATIC() { return getToken(JavaParser.STATIC, 0); }
		public TerminalNode STRICTFP() { return getToken(JavaParser.STRICTFP, 0); }
		public InterfaceMethodModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceMethodModifier; }
	}

	public final InterfaceMethodModifierContext interfaceMethodModifier() throws RecognitionException {
		InterfaceMethodModifierContext _localctx = new InterfaceMethodModifierContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_interfaceMethodModifier);
		try {
			setState(579);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MODULE:
			case OPEN:
			case REQUIRES:
			case EXPORTS:
			case OPENS:
			case TO:
			case USES:
			case PROVIDES:
			case WITH:
			case TRANSITIVE:
			case VAR:
			case YIELD:
			case RECORD:
			case SEALED:
			case PERMITS:
			case AT:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(573);
				annotation();
				}
				break;
			case PUBLIC:
				enterOuterAlt(_localctx, 2);
				{
				setState(574);
				match(PUBLIC);
				}
				break;
			case ABSTRACT:
				enterOuterAlt(_localctx, 3);
				{
				setState(575);
				match(ABSTRACT);
				}
				break;
			case DEFAULT:
				enterOuterAlt(_localctx, 4);
				{
				setState(576);
				match(DEFAULT);
				}
				break;
			case STATIC:
				enterOuterAlt(_localctx, 5);
				{
				setState(577);
				match(STATIC);
				}
				break;
			case STRICTFP:
				enterOuterAlt(_localctx, 6);
				{
				setState(578);
				match(STRICTFP);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GenericInterfaceMethodDeclarationContext extends ParserRuleContext {
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public InterfaceCommonBodyDeclarationContext interfaceCommonBodyDeclaration() {
			return getRuleContext(InterfaceCommonBodyDeclarationContext.class,0);
		}
		public List<InterfaceMethodModifierContext> interfaceMethodModifier() {
			return getRuleContexts(InterfaceMethodModifierContext.class);
		}
		public InterfaceMethodModifierContext interfaceMethodModifier(int i) {
			return getRuleContext(InterfaceMethodModifierContext.class,i);
		}
		public GenericInterfaceMethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_genericInterfaceMethodDeclaration; }
	}

	public final GenericInterfaceMethodDeclarationContext genericInterfaceMethodDeclaration() throws RecognitionException {
		GenericInterfaceMethodDeclarationContext _localctx = new GenericInterfaceMethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_genericInterfaceMethodDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(584);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -2250940820221950L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 576460752303423491L) != 0) || _la==IDENTIFIER) {
				{
				{
				setState(581);
				interfaceMethodModifier();
				}
				}
				setState(586);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(587);
			typeParameters();
			setState(588);
			interfaceCommonBodyDeclaration();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InterfaceCommonBodyDeclarationContext extends ParserRuleContext {
		public TypeTypeOrVoidContext typeTypeOrVoid() {
			return getRuleContext(TypeTypeOrVoidContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public FormalParametersContext formalParameters() {
			return getRuleContext(FormalParametersContext.class,0);
		}
		public MethodBodyContext methodBody() {
			return getRuleContext(MethodBodyContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public List<TerminalNode> LBRACK() { return getTokens(JavaParser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(JavaParser.LBRACK, i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(JavaParser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(JavaParser.RBRACK, i);
		}
		public TerminalNode THROWS() { return getToken(JavaParser.THROWS, 0); }
		public QualifiedNameListContext qualifiedNameList() {
			return getRuleContext(QualifiedNameListContext.class,0);
		}
		public InterfaceCommonBodyDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceCommonBodyDeclaration; }
	}

	public final InterfaceCommonBodyDeclarationContext interfaceCommonBodyDeclaration() throws RecognitionException {
		InterfaceCommonBodyDeclarationContext _localctx = new InterfaceCommonBodyDeclarationContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_interfaceCommonBodyDeclaration);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(593);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(590);
					annotation();
					}
					} 
				}
				setState(595);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,54,_ctx);
			}
			setState(596);
			typeTypeOrVoid();
			setState(597);
			identifier();
			setState(598);
			formalParameters();
			setState(603);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACK) {
				{
				{
				setState(599);
				match(LBRACK);
				setState(600);
				match(RBRACK);
				}
				}
				setState(605);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(608);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==THROWS) {
				{
				setState(606);
				match(THROWS);
				setState(607);
				qualifiedNameList();
				}
			}

			setState(610);
			methodBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableDeclaratorsContext extends ParserRuleContext {
		public List<VariableDeclaratorContext> variableDeclarator() {
			return getRuleContexts(VariableDeclaratorContext.class);
		}
		public VariableDeclaratorContext variableDeclarator(int i) {
			return getRuleContext(VariableDeclaratorContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(JavaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JavaParser.COMMA, i);
		}
		public VariableDeclaratorsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarators; }
	}

	public final VariableDeclaratorsContext variableDeclarators() throws RecognitionException {
		VariableDeclaratorsContext _localctx = new VariableDeclaratorsContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_variableDeclarators);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(612);
			variableDeclarator();
			setState(617);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(613);
				match(COMMA);
				setState(614);
				variableDeclarator();
				}
				}
				setState(619);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableDeclaratorContext extends ParserRuleContext {
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(JavaParser.ASSIGN, 0); }
		public VariableInitializerContext variableInitializer() {
			return getRuleContext(VariableInitializerContext.class,0);
		}
		public VariableDeclaratorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclarator; }
	}

	public final VariableDeclaratorContext variableDeclarator() throws RecognitionException {
		VariableDeclaratorContext _localctx = new VariableDeclaratorContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_variableDeclarator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(620);
			variableDeclaratorId();
			setState(623);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(621);
				match(ASSIGN);
				setState(622);
				variableInitializer();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableDeclaratorIdContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<TerminalNode> LBRACK() { return getTokens(JavaParser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(JavaParser.LBRACK, i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(JavaParser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(JavaParser.RBRACK, i);
		}
		public VariableDeclaratorIdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaratorId; }
	}

	public final VariableDeclaratorIdContext variableDeclaratorId() throws RecognitionException {
		VariableDeclaratorIdContext _localctx = new VariableDeclaratorIdContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_variableDeclaratorId);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(625);
			identifier();
			setState(630);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==LBRACK) {
				{
				{
				setState(626);
				match(LBRACK);
				setState(627);
				match(RBRACK);
				}
				}
				setState(632);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableInitializerContext extends ParserRuleContext {
		public ArrayInitializerContext arrayInitializer() {
			return getRuleContext(ArrayInitializerContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableInitializer; }
	}

	public final VariableInitializerContext variableInitializer() throws RecognitionException {
		VariableInitializerContext _localctx = new VariableInitializerContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_variableInitializer);
		try {
			setState(635);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LBRACE:
				enterOuterAlt(_localctx, 1);
				{
				setState(633);
				arrayInitializer();
				}
				break;
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case NEW:
			case SHORT:
			case SUPER:
			case SWITCH:
			case THIS:
			case VOID:
			case MODULE:
			case OPEN:
			case REQUIRES:
			case EXPORTS:
			case OPENS:
			case TO:
			case USES:
			case PROVIDES:
			case WITH:
			case TRANSITIVE:
			case VAR:
			case YIELD:
			case RECORD:
			case SEALED:
			case PERMITS:
			case DECIMAL_LITERAL:
			case HEX_LITERAL:
			case OCT_LITERAL:
			case BINARY_LITERAL:
			case FLOAT_LITERAL:
			case HEX_FLOAT_LITERAL:
			case BOOL_LITERAL:
			case CHAR_LITERAL:
			case STRING_LITERAL:
			case TEXT_BLOCK:
			case NULL_LITERAL:
			case LPAREN:
			case LT:
			case BANG:
			case TILDE:
			case INC:
			case DEC:
			case ADD:
			case SUB:
			case AT:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(634);
				expression(0);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayInitializerContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(JavaParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(JavaParser.RBRACE, 0); }
		public List<VariableInitializerContext> variableInitializer() {
			return getRuleContexts(VariableInitializerContext.class);
		}
		public VariableInitializerContext variableInitializer(int i) {
			return getRuleContext(VariableInitializerContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(JavaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JavaParser.COMMA, i);
		}
		public ArrayInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayInitializer; }
	}

	public final ArrayInitializerContext arrayInitializer() throws RecognitionException {
		ArrayInitializerContext _localctx = new ArrayInitializerContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_arrayInitializer);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(637);
			match(LBRACE);
			setState(649);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 3)) & ~0x3f) == 0 && ((1L << (_la - 3)) & 9223127275610966053L) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & -9151314313938456577L) != 0)) {
				{
				setState(638);
				variableInitializer();
				setState(643);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,61,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(639);
						match(COMMA);
						setState(640);
						variableInitializer();
						}
						} 
					}
					setState(645);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,61,_ctx);
				}
				setState(647);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(646);
					match(COMMA);
					}
				}

				}
			}

			setState(651);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassOrInterfaceTypeContext extends ParserRuleContext {
		public TypeIdentifierContext typeIdentifier() {
			return getRuleContext(TypeIdentifierContext.class,0);
		}
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(JavaParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(JavaParser.DOT, i);
		}
		public List<TypeArgumentsContext> typeArguments() {
			return getRuleContexts(TypeArgumentsContext.class);
		}
		public TypeArgumentsContext typeArguments(int i) {
			return getRuleContext(TypeArgumentsContext.class,i);
		}
		public ClassOrInterfaceTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classOrInterfaceType; }
	}

	public final ClassOrInterfaceTypeContext classOrInterfaceType() throws RecognitionException {
		ClassOrInterfaceTypeContext _localctx = new ClassOrInterfaceTypeContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_classOrInterfaceType);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(661);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(653);
					identifier();
					setState(655);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==LT) {
						{
						setState(654);
						typeArguments();
						}
					}

					setState(657);
					match(DOT);
					}
					} 
				}
				setState(663);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,65,_ctx);
			}
			setState(664);
			typeIdentifier();
			setState(666);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,66,_ctx) ) {
			case 1:
				{
				setState(665);
				typeArguments();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeArgumentContext extends ParserRuleContext {
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public TerminalNode QUESTION() { return getToken(JavaParser.QUESTION, 0); }
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public TerminalNode EXTENDS() { return getToken(JavaParser.EXTENDS, 0); }
		public TerminalNode SUPER() { return getToken(JavaParser.SUPER, 0); }
		public TypeArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeArgument; }
	}

	public final TypeArgumentContext typeArgument() throws RecognitionException {
		TypeArgumentContext _localctx = new TypeArgumentContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_typeArgument);
		int _la;
		try {
			setState(680);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,69,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(668);
				typeType();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(672);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 51)) & ~0x3f) == 0 && ((1L << (_la - 51)) & 32767L) != 0) || _la==AT || _la==IDENTIFIER) {
					{
					{
					setState(669);
					annotation();
					}
					}
					setState(674);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(675);
				match(QUESTION);
				setState(678);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==EXTENDS || _la==SUPER) {
					{
					setState(676);
					_la = _input.LA(1);
					if ( !(_la==EXTENDS || _la==SUPER) ) {
					_errHandler.recoverInline(this);
					}
					else {
						if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
						_errHandler.reportMatch(this);
						consume();
					}
					setState(677);
					typeType();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class QualifiedNameListContext extends ParserRuleContext {
		public List<QualifiedNameContext> qualifiedName() {
			return getRuleContexts(QualifiedNameContext.class);
		}
		public QualifiedNameContext qualifiedName(int i) {
			return getRuleContext(QualifiedNameContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(JavaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JavaParser.COMMA, i);
		}
		public QualifiedNameListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedNameList; }
	}

	public final QualifiedNameListContext qualifiedNameList() throws RecognitionException {
		QualifiedNameListContext _localctx = new QualifiedNameListContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_qualifiedNameList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(682);
			qualifiedName();
			setState(687);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(683);
				match(COMMA);
				setState(684);
				qualifiedName();
				}
				}
				setState(689);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FormalParametersContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(JavaParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(JavaParser.RPAREN, 0); }
		public ReceiverParameterContext receiverParameter() {
			return getRuleContext(ReceiverParameterContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(JavaParser.COMMA, 0); }
		public FormalParameterListContext formalParameterList() {
			return getRuleContext(FormalParameterListContext.class,0);
		}
		public FormalParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameters; }
	}

	public final FormalParametersContext formalParameters() throws RecognitionException {
		FormalParametersContext _localctx = new FormalParametersContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_formalParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(690);
			match(LPAREN);
			setState(702);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,74,_ctx) ) {
			case 1:
				{
				setState(692);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 3)) & ~0x3f) == 0 && ((1L << (_la - 3)) & 9223090579141953573L) != 0) || _la==AT || _la==IDENTIFIER) {
					{
					setState(691);
					receiverParameter();
					}
				}

				}
				break;
			case 2:
				{
				setState(694);
				receiverParameter();
				setState(697);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(695);
					match(COMMA);
					setState(696);
					formalParameterList();
					}
				}

				}
				break;
			case 3:
				{
				setState(700);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 3)) & ~0x3f) == 0 && ((1L << (_la - 3)) & 9223090579141986341L) != 0) || _la==AT || _la==IDENTIFIER) {
					{
					setState(699);
					formalParameterList();
					}
				}

				}
				break;
			}
			setState(704);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReceiverParameterContext extends ParserRuleContext {
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public TerminalNode THIS() { return getToken(JavaParser.THIS, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(JavaParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(JavaParser.DOT, i);
		}
		public ReceiverParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_receiverParameter; }
	}

	public final ReceiverParameterContext receiverParameter() throws RecognitionException {
		ReceiverParameterContext _localctx = new ReceiverParameterContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_receiverParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(706);
			typeType();
			setState(712);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 51)) & ~0x3f) == 0 && ((1L << (_la - 51)) & 32767L) != 0) || _la==IDENTIFIER) {
				{
				{
				setState(707);
				identifier();
				setState(708);
				match(DOT);
				}
				}
				setState(714);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(715);
			match(THIS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FormalParameterListContext extends ParserRuleContext {
		public List<FormalParameterContext> formalParameter() {
			return getRuleContexts(FormalParameterContext.class);
		}
		public FormalParameterContext formalParameter(int i) {
			return getRuleContext(FormalParameterContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(JavaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JavaParser.COMMA, i);
		}
		public LastFormalParameterContext lastFormalParameter() {
			return getRuleContext(LastFormalParameterContext.class,0);
		}
		public FormalParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameterList; }
	}

	public final FormalParameterListContext formalParameterList() throws RecognitionException {
		FormalParameterListContext _localctx = new FormalParameterListContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_formalParameterList);
		int _la;
		try {
			int _alt;
			setState(730);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,78,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(717);
				formalParameter();
				setState(722);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,76,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(718);
						match(COMMA);
						setState(719);
						formalParameter();
						}
						} 
					}
					setState(724);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,76,_ctx);
				}
				setState(727);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COMMA) {
					{
					setState(725);
					match(COMMA);
					setState(726);
					lastFormalParameter();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(729);
				lastFormalParameter();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FormalParameterContext extends ParserRuleContext {
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public List<VariableModifierContext> variableModifier() {
			return getRuleContexts(VariableModifierContext.class);
		}
		public VariableModifierContext variableModifier(int i) {
			return getRuleContext(VariableModifierContext.class,i);
		}
		public FormalParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameter; }
	}

	public final FormalParameterContext formalParameter() throws RecognitionException {
		FormalParameterContext _localctx = new FormalParameterContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_formalParameter);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(735);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,79,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(732);
					variableModifier();
					}
					} 
				}
				setState(737);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,79,_ctx);
			}
			setState(738);
			typeType();
			setState(739);
			variableDeclaratorId();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LastFormalParameterContext extends ParserRuleContext {
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public TerminalNode ELLIPSIS() { return getToken(JavaParser.ELLIPSIS, 0); }
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public List<VariableModifierContext> variableModifier() {
			return getRuleContexts(VariableModifierContext.class);
		}
		public VariableModifierContext variableModifier(int i) {
			return getRuleContext(VariableModifierContext.class,i);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public LastFormalParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lastFormalParameter; }
	}

	public final LastFormalParameterContext lastFormalParameter() throws RecognitionException {
		LastFormalParameterContext _localctx = new LastFormalParameterContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_lastFormalParameter);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(744);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,80,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(741);
					variableModifier();
					}
					} 
				}
				setState(746);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,80,_ctx);
			}
			setState(747);
			typeType();
			setState(751);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 51)) & ~0x3f) == 0 && ((1L << (_la - 51)) & 32767L) != 0) || _la==AT || _la==IDENTIFIER) {
				{
				{
				setState(748);
				annotation();
				}
				}
				setState(753);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(754);
			match(ELLIPSIS);
			setState(755);
			variableDeclaratorId();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LambdaLVTIListContext extends ParserRuleContext {
		public List<LambdaLVTIParameterContext> lambdaLVTIParameter() {
			return getRuleContexts(LambdaLVTIParameterContext.class);
		}
		public LambdaLVTIParameterContext lambdaLVTIParameter(int i) {
			return getRuleContext(LambdaLVTIParameterContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(JavaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JavaParser.COMMA, i);
		}
		public LambdaLVTIListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaLVTIList; }
	}

	public final LambdaLVTIListContext lambdaLVTIList() throws RecognitionException {
		LambdaLVTIListContext _localctx = new LambdaLVTIListContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_lambdaLVTIList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(757);
			lambdaLVTIParameter();
			setState(762);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(758);
				match(COMMA);
				setState(759);
				lambdaLVTIParameter();
				}
				}
				setState(764);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LambdaLVTIParameterContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(JavaParser.VAR, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<VariableModifierContext> variableModifier() {
			return getRuleContexts(VariableModifierContext.class);
		}
		public VariableModifierContext variableModifier(int i) {
			return getRuleContext(VariableModifierContext.class,i);
		}
		public LambdaLVTIParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaLVTIParameter; }
	}

	public final LambdaLVTIParameterContext lambdaLVTIParameter() throws RecognitionException {
		LambdaLVTIParameterContext _localctx = new LambdaLVTIParameterContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_lambdaLVTIParameter);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(768);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,83,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(765);
					variableModifier();
					}
					} 
				}
				setState(770);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,83,_ctx);
			}
			setState(771);
			match(VAR);
			setState(772);
			identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class QualifiedNameContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(JavaParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(JavaParser.DOT, i);
		}
		public QualifiedNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_qualifiedName; }
	}

	public final QualifiedNameContext qualifiedName() throws RecognitionException {
		QualifiedNameContext _localctx = new QualifiedNameContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_qualifiedName);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(774);
			identifier();
			setState(779);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,84,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(775);
					match(DOT);
					setState(776);
					identifier();
					}
					} 
				}
				setState(781);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,84,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralContext extends ParserRuleContext {
		public IntegerLiteralContext integerLiteral() {
			return getRuleContext(IntegerLiteralContext.class,0);
		}
		public FloatLiteralContext floatLiteral() {
			return getRuleContext(FloatLiteralContext.class,0);
		}
		public TerminalNode CHAR_LITERAL() { return getToken(JavaParser.CHAR_LITERAL, 0); }
		public TerminalNode STRING_LITERAL() { return getToken(JavaParser.STRING_LITERAL, 0); }
		public TerminalNode BOOL_LITERAL() { return getToken(JavaParser.BOOL_LITERAL, 0); }
		public TerminalNode NULL_LITERAL() { return getToken(JavaParser.NULL_LITERAL, 0); }
		public TerminalNode TEXT_BLOCK() { return getToken(JavaParser.TEXT_BLOCK, 0); }
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_literal);
		try {
			setState(789);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case DECIMAL_LITERAL:
			case HEX_LITERAL:
			case OCT_LITERAL:
			case BINARY_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(782);
				integerLiteral();
				}
				break;
			case FLOAT_LITERAL:
			case HEX_FLOAT_LITERAL:
				enterOuterAlt(_localctx, 2);
				{
				setState(783);
				floatLiteral();
				}
				break;
			case CHAR_LITERAL:
				enterOuterAlt(_localctx, 3);
				{
				setState(784);
				match(CHAR_LITERAL);
				}
				break;
			case STRING_LITERAL:
				enterOuterAlt(_localctx, 4);
				{
				setState(785);
				match(STRING_LITERAL);
				}
				break;
			case BOOL_LITERAL:
				enterOuterAlt(_localctx, 5);
				{
				setState(786);
				match(BOOL_LITERAL);
				}
				break;
			case NULL_LITERAL:
				enterOuterAlt(_localctx, 6);
				{
				setState(787);
				match(NULL_LITERAL);
				}
				break;
			case TEXT_BLOCK:
				enterOuterAlt(_localctx, 7);
				{
				setState(788);
				match(TEXT_BLOCK);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IntegerLiteralContext extends ParserRuleContext {
		public TerminalNode DECIMAL_LITERAL() { return getToken(JavaParser.DECIMAL_LITERAL, 0); }
		public TerminalNode HEX_LITERAL() { return getToken(JavaParser.HEX_LITERAL, 0); }
		public TerminalNode OCT_LITERAL() { return getToken(JavaParser.OCT_LITERAL, 0); }
		public TerminalNode BINARY_LITERAL() { return getToken(JavaParser.BINARY_LITERAL, 0); }
		public IntegerLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_integerLiteral; }
	}

	public final IntegerLiteralContext integerLiteral() throws RecognitionException {
		IntegerLiteralContext _localctx = new IntegerLiteralContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_integerLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(791);
			_la = _input.LA(1);
			if ( !(((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & 15L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FloatLiteralContext extends ParserRuleContext {
		public TerminalNode FLOAT_LITERAL() { return getToken(JavaParser.FLOAT_LITERAL, 0); }
		public TerminalNode HEX_FLOAT_LITERAL() { return getToken(JavaParser.HEX_FLOAT_LITERAL, 0); }
		public FloatLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_floatLiteral; }
	}

	public final FloatLiteralContext floatLiteral() throws RecognitionException {
		FloatLiteralContext _localctx = new FloatLiteralContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_floatLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(793);
			_la = _input.LA(1);
			if ( !(_la==FLOAT_LITERAL || _la==HEX_FLOAT_LITERAL) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AltAnnotationQualifiedNameContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(JavaParser.AT, 0); }
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(JavaParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(JavaParser.DOT, i);
		}
		public AltAnnotationQualifiedNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_altAnnotationQualifiedName; }
	}

	public final AltAnnotationQualifiedNameContext altAnnotationQualifiedName() throws RecognitionException {
		AltAnnotationQualifiedNameContext _localctx = new AltAnnotationQualifiedNameContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_altAnnotationQualifiedName);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(800);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 51)) & ~0x3f) == 0 && ((1L << (_la - 51)) & 32767L) != 0) || _la==IDENTIFIER) {
				{
				{
				setState(795);
				identifier();
				setState(796);
				match(DOT);
				}
				}
				setState(802);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(803);
			match(AT);
			setState(804);
			identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AnnotationContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(JavaParser.AT, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public AltAnnotationQualifiedNameContext altAnnotationQualifiedName() {
			return getRuleContext(AltAnnotationQualifiedNameContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(JavaParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(JavaParser.RPAREN, 0); }
		public ElementValuePairsContext elementValuePairs() {
			return getRuleContext(ElementValuePairsContext.class,0);
		}
		public ElementValueContext elementValue() {
			return getRuleContext(ElementValueContext.class,0);
		}
		public AnnotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotation; }
	}

	public final AnnotationContext annotation() throws RecognitionException {
		AnnotationContext _localctx = new AnnotationContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_annotation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(809);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,87,_ctx) ) {
			case 1:
				{
				setState(806);
				match(AT);
				setState(807);
				qualifiedName();
				}
				break;
			case 2:
				{
				setState(808);
				altAnnotationQualifiedName();
				}
				break;
			}
			setState(817);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(811);
				match(LPAREN);
				setState(814);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,88,_ctx) ) {
				case 1:
					{
					setState(812);
					elementValuePairs();
					}
					break;
				case 2:
					{
					setState(813);
					elementValue();
					}
					break;
				}
				setState(816);
				match(RPAREN);
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ElementValuePairsContext extends ParserRuleContext {
		public List<ElementValuePairContext> elementValuePair() {
			return getRuleContexts(ElementValuePairContext.class);
		}
		public ElementValuePairContext elementValuePair(int i) {
			return getRuleContext(ElementValuePairContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(JavaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JavaParser.COMMA, i);
		}
		public ElementValuePairsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementValuePairs; }
	}

	public final ElementValuePairsContext elementValuePairs() throws RecognitionException {
		ElementValuePairsContext _localctx = new ElementValuePairsContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_elementValuePairs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(819);
			elementValuePair();
			setState(824);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(820);
				match(COMMA);
				setState(821);
				elementValuePair();
				}
				}
				setState(826);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ElementValuePairContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(JavaParser.ASSIGN, 0); }
		public ElementValueContext elementValue() {
			return getRuleContext(ElementValueContext.class,0);
		}
		public ElementValuePairContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementValuePair; }
	}

	public final ElementValuePairContext elementValuePair() throws RecognitionException {
		ElementValuePairContext _localctx = new ElementValuePairContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_elementValuePair);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(827);
			identifier();
			setState(828);
			match(ASSIGN);
			setState(829);
			elementValue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ElementValueContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public ElementValueArrayInitializerContext elementValueArrayInitializer() {
			return getRuleContext(ElementValueArrayInitializerContext.class,0);
		}
		public ElementValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementValue; }
	}

	public final ElementValueContext elementValue() throws RecognitionException {
		ElementValueContext _localctx = new ElementValueContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_elementValue);
		try {
			setState(834);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,91,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(831);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(832);
				annotation();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(833);
				elementValueArrayInitializer();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ElementValueArrayInitializerContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(JavaParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(JavaParser.RBRACE, 0); }
		public List<ElementValueContext> elementValue() {
			return getRuleContexts(ElementValueContext.class);
		}
		public ElementValueContext elementValue(int i) {
			return getRuleContext(ElementValueContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(JavaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JavaParser.COMMA, i);
		}
		public ElementValueArrayInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elementValueArrayInitializer; }
	}

	public final ElementValueArrayInitializerContext elementValueArrayInitializer() throws RecognitionException {
		ElementValueArrayInitializerContext _localctx = new ElementValueArrayInitializerContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_elementValueArrayInitializer);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(836);
			match(LBRACE);
			setState(845);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 3)) & ~0x3f) == 0 && ((1L << (_la - 3)) & 9223127275610966053L) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & -9151314313938456577L) != 0)) {
				{
				setState(837);
				elementValue();
				setState(842);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,92,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(838);
						match(COMMA);
						setState(839);
						elementValue();
						}
						} 
					}
					setState(844);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,92,_ctx);
				}
				}
			}

			setState(848);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COMMA) {
				{
				setState(847);
				match(COMMA);
				}
			}

			setState(850);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AnnotationTypeDeclarationContext extends ParserRuleContext {
		public TerminalNode AT() { return getToken(JavaParser.AT, 0); }
		public TerminalNode INTERFACE() { return getToken(JavaParser.INTERFACE, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public AnnotationTypeBodyContext annotationTypeBody() {
			return getRuleContext(AnnotationTypeBodyContext.class,0);
		}
		public AnnotationTypeDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationTypeDeclaration; }
	}

	public final AnnotationTypeDeclarationContext annotationTypeDeclaration() throws RecognitionException {
		AnnotationTypeDeclarationContext _localctx = new AnnotationTypeDeclarationContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_annotationTypeDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(852);
			match(AT);
			setState(853);
			match(INTERFACE);
			setState(854);
			identifier();
			setState(855);
			annotationTypeBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AnnotationTypeBodyContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(JavaParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(JavaParser.RBRACE, 0); }
		public List<AnnotationTypeElementDeclarationContext> annotationTypeElementDeclaration() {
			return getRuleContexts(AnnotationTypeElementDeclarationContext.class);
		}
		public AnnotationTypeElementDeclarationContext annotationTypeElementDeclaration(int i) {
			return getRuleContext(AnnotationTypeElementDeclarationContext.class,i);
		}
		public AnnotationTypeBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationTypeBody; }
	}

	public final AnnotationTypeBodyContext annotationTypeBody() throws RecognitionException {
		AnnotationTypeBodyContext _localctx = new AnnotationTypeBodyContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_annotationTypeBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(857);
			match(LBRACE);
			setState(861);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -1613058852699350L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 576460752304472067L) != 0) || _la==IDENTIFIER) {
				{
				{
				setState(858);
				annotationTypeElementDeclaration();
				}
				}
				setState(863);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(864);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AnnotationTypeElementDeclarationContext extends ParserRuleContext {
		public AnnotationTypeElementRestContext annotationTypeElementRest() {
			return getRuleContext(AnnotationTypeElementRestContext.class,0);
		}
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public TerminalNode SEMI() { return getToken(JavaParser.SEMI, 0); }
		public AnnotationTypeElementDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationTypeElementDeclaration; }
	}

	public final AnnotationTypeElementDeclarationContext annotationTypeElementDeclaration() throws RecognitionException {
		AnnotationTypeElementDeclarationContext _localctx = new AnnotationTypeElementDeclarationContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_annotationTypeElementDeclaration);
		try {
			int _alt;
			setState(874);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ABSTRACT:
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case CLASS:
			case DOUBLE:
			case ENUM:
			case FINAL:
			case FLOAT:
			case INT:
			case INTERFACE:
			case LONG:
			case NATIVE:
			case PRIVATE:
			case PROTECTED:
			case PUBLIC:
			case SHORT:
			case STATIC:
			case STRICTFP:
			case SYNCHRONIZED:
			case TRANSIENT:
			case VOLATILE:
			case MODULE:
			case OPEN:
			case REQUIRES:
			case EXPORTS:
			case OPENS:
			case TO:
			case USES:
			case PROVIDES:
			case WITH:
			case TRANSITIVE:
			case VAR:
			case YIELD:
			case RECORD:
			case SEALED:
			case PERMITS:
			case AT:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(869);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,96,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(866);
						modifier();
						}
						} 
					}
					setState(871);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,96,_ctx);
				}
				setState(872);
				annotationTypeElementRest();
				}
				break;
			case SEMI:
				enterOuterAlt(_localctx, 2);
				{
				setState(873);
				match(SEMI);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AnnotationTypeElementRestContext extends ParserRuleContext {
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public AnnotationMethodOrConstantRestContext annotationMethodOrConstantRest() {
			return getRuleContext(AnnotationMethodOrConstantRestContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(JavaParser.SEMI, 0); }
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public InterfaceDeclarationContext interfaceDeclaration() {
			return getRuleContext(InterfaceDeclarationContext.class,0);
		}
		public EnumDeclarationContext enumDeclaration() {
			return getRuleContext(EnumDeclarationContext.class,0);
		}
		public AnnotationTypeDeclarationContext annotationTypeDeclaration() {
			return getRuleContext(AnnotationTypeDeclarationContext.class,0);
		}
		public AnnotationTypeElementRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationTypeElementRest; }
	}

	public final AnnotationTypeElementRestContext annotationTypeElementRest() throws RecognitionException {
		AnnotationTypeElementRestContext _localctx = new AnnotationTypeElementRestContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_annotationTypeElementRest);
		try {
			setState(896);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,102,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(876);
				typeType();
				setState(877);
				annotationMethodOrConstantRest();
				setState(878);
				match(SEMI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(880);
				classDeclaration();
				setState(882);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,98,_ctx) ) {
				case 1:
					{
					setState(881);
					match(SEMI);
					}
					break;
				}
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(884);
				interfaceDeclaration();
				setState(886);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,99,_ctx) ) {
				case 1:
					{
					setState(885);
					match(SEMI);
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(888);
				enumDeclaration();
				setState(890);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,100,_ctx) ) {
				case 1:
					{
					setState(889);
					match(SEMI);
					}
					break;
				}
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(892);
				annotationTypeDeclaration();
				setState(894);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,101,_ctx) ) {
				case 1:
					{
					setState(893);
					match(SEMI);
					}
					break;
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AnnotationMethodOrConstantRestContext extends ParserRuleContext {
		public AnnotationMethodRestContext annotationMethodRest() {
			return getRuleContext(AnnotationMethodRestContext.class,0);
		}
		public AnnotationConstantRestContext annotationConstantRest() {
			return getRuleContext(AnnotationConstantRestContext.class,0);
		}
		public AnnotationMethodOrConstantRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationMethodOrConstantRest; }
	}

	public final AnnotationMethodOrConstantRestContext annotationMethodOrConstantRest() throws RecognitionException {
		AnnotationMethodOrConstantRestContext _localctx = new AnnotationMethodOrConstantRestContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_annotationMethodOrConstantRest);
		try {
			setState(900);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,103,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(898);
				annotationMethodRest();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(899);
				annotationConstantRest();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AnnotationMethodRestContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(JavaParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(JavaParser.RPAREN, 0); }
		public DefaultValueContext defaultValue() {
			return getRuleContext(DefaultValueContext.class,0);
		}
		public AnnotationMethodRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationMethodRest; }
	}

	public final AnnotationMethodRestContext annotationMethodRest() throws RecognitionException {
		AnnotationMethodRestContext _localctx = new AnnotationMethodRestContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_annotationMethodRest);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(902);
			identifier();
			setState(903);
			match(LPAREN);
			setState(904);
			match(RPAREN);
			setState(906);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==DEFAULT) {
				{
				setState(905);
				defaultValue();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AnnotationConstantRestContext extends ParserRuleContext {
		public VariableDeclaratorsContext variableDeclarators() {
			return getRuleContext(VariableDeclaratorsContext.class,0);
		}
		public AnnotationConstantRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationConstantRest; }
	}

	public final AnnotationConstantRestContext annotationConstantRest() throws RecognitionException {
		AnnotationConstantRestContext _localctx = new AnnotationConstantRestContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_annotationConstantRest);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(908);
			variableDeclarators();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DefaultValueContext extends ParserRuleContext {
		public TerminalNode DEFAULT() { return getToken(JavaParser.DEFAULT, 0); }
		public ElementValueContext elementValue() {
			return getRuleContext(ElementValueContext.class,0);
		}
		public DefaultValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultValue; }
	}

	public final DefaultValueContext defaultValue() throws RecognitionException {
		DefaultValueContext _localctx = new DefaultValueContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_defaultValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(910);
			match(DEFAULT);
			setState(911);
			elementValue();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ModuleDeclarationContext extends ParserRuleContext {
		public TerminalNode MODULE() { return getToken(JavaParser.MODULE, 0); }
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public ModuleBodyContext moduleBody() {
			return getRuleContext(ModuleBodyContext.class,0);
		}
		public TerminalNode OPEN() { return getToken(JavaParser.OPEN, 0); }
		public ModuleDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moduleDeclaration; }
	}

	public final ModuleDeclarationContext moduleDeclaration() throws RecognitionException {
		ModuleDeclarationContext _localctx = new ModuleDeclarationContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_moduleDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(914);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==OPEN) {
				{
				setState(913);
				match(OPEN);
				}
			}

			setState(916);
			match(MODULE);
			setState(917);
			qualifiedName();
			setState(918);
			moduleBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ModuleBodyContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(JavaParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(JavaParser.RBRACE, 0); }
		public List<ModuleDirectiveContext> moduleDirective() {
			return getRuleContexts(ModuleDirectiveContext.class);
		}
		public ModuleDirectiveContext moduleDirective(int i) {
			return getRuleContext(ModuleDirectiveContext.class,i);
		}
		public ModuleBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moduleBody; }
	}

	public final ModuleBodyContext moduleBody() throws RecognitionException {
		ModuleBodyContext _localctx = new ModuleBodyContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_moduleBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(920);
			match(LBRACE);
			setState(924);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 495395959010754560L) != 0)) {
				{
				{
				setState(921);
				moduleDirective();
				}
				}
				setState(926);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(927);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ModuleDirectiveContext extends ParserRuleContext {
		public TerminalNode REQUIRES() { return getToken(JavaParser.REQUIRES, 0); }
		public List<QualifiedNameContext> qualifiedName() {
			return getRuleContexts(QualifiedNameContext.class);
		}
		public QualifiedNameContext qualifiedName(int i) {
			return getRuleContext(QualifiedNameContext.class,i);
		}
		public TerminalNode SEMI() { return getToken(JavaParser.SEMI, 0); }
		public List<RequiresModifierContext> requiresModifier() {
			return getRuleContexts(RequiresModifierContext.class);
		}
		public RequiresModifierContext requiresModifier(int i) {
			return getRuleContext(RequiresModifierContext.class,i);
		}
		public TerminalNode EXPORTS() { return getToken(JavaParser.EXPORTS, 0); }
		public TerminalNode TO() { return getToken(JavaParser.TO, 0); }
		public TerminalNode OPENS() { return getToken(JavaParser.OPENS, 0); }
		public TerminalNode USES() { return getToken(JavaParser.USES, 0); }
		public TerminalNode PROVIDES() { return getToken(JavaParser.PROVIDES, 0); }
		public TerminalNode WITH() { return getToken(JavaParser.WITH, 0); }
		public ModuleDirectiveContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_moduleDirective; }
	}

	public final ModuleDirectiveContext moduleDirective() throws RecognitionException {
		ModuleDirectiveContext _localctx = new ModuleDirectiveContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_moduleDirective);
		int _la;
		try {
			int _alt;
			setState(965);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case REQUIRES:
				enterOuterAlt(_localctx, 1);
				{
				setState(929);
				match(REQUIRES);
				setState(933);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,107,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(930);
						requiresModifier();
						}
						} 
					}
					setState(935);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,107,_ctx);
				}
				setState(936);
				qualifiedName();
				setState(937);
				match(SEMI);
				}
				break;
			case EXPORTS:
				enterOuterAlt(_localctx, 2);
				{
				setState(939);
				match(EXPORTS);
				setState(940);
				qualifiedName();
				setState(943);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TO) {
					{
					setState(941);
					match(TO);
					setState(942);
					qualifiedName();
					}
				}

				setState(945);
				match(SEMI);
				}
				break;
			case OPENS:
				enterOuterAlt(_localctx, 3);
				{
				setState(947);
				match(OPENS);
				setState(948);
				qualifiedName();
				setState(951);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==TO) {
					{
					setState(949);
					match(TO);
					setState(950);
					qualifiedName();
					}
				}

				setState(953);
				match(SEMI);
				}
				break;
			case USES:
				enterOuterAlt(_localctx, 4);
				{
				setState(955);
				match(USES);
				setState(956);
				qualifiedName();
				setState(957);
				match(SEMI);
				}
				break;
			case PROVIDES:
				enterOuterAlt(_localctx, 5);
				{
				setState(959);
				match(PROVIDES);
				setState(960);
				qualifiedName();
				setState(961);
				match(WITH);
				setState(962);
				qualifiedName();
				setState(963);
				match(SEMI);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class RequiresModifierContext extends ParserRuleContext {
		public TerminalNode TRANSITIVE() { return getToken(JavaParser.TRANSITIVE, 0); }
		public TerminalNode STATIC() { return getToken(JavaParser.STATIC, 0); }
		public RequiresModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_requiresModifier; }
	}

	public final RequiresModifierContext requiresModifier() throws RecognitionException {
		RequiresModifierContext _localctx = new RequiresModifierContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_requiresModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(967);
			_la = _input.LA(1);
			if ( !(_la==STATIC || _la==TRANSITIVE) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(JavaParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(JavaParser.RBRACE, 0); }
		public List<BlockStatementContext> blockStatement() {
			return getRuleContexts(BlockStatementContext.class);
		}
		public BlockStatementContext blockStatement(int i) {
			return getRuleContext(BlockStatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(969);
			match(LBRACE);
			setState(973);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -668508564985026L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 576461783331602427L) != 0) || _la==IDENTIFIER) {
				{
				{
				setState(970);
				blockStatement();
				}
				}
				setState(975);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(976);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockStatementContext extends ParserRuleContext {
		public LocalVariableDeclarationContext localVariableDeclaration() {
			return getRuleContext(LocalVariableDeclarationContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(JavaParser.SEMI, 0); }
		public LocalTypeDeclarationContext localTypeDeclaration() {
			return getRuleContext(LocalTypeDeclarationContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public BlockStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockStatement; }
	}

	public final BlockStatementContext blockStatement() throws RecognitionException {
		BlockStatementContext _localctx = new BlockStatementContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_blockStatement);
		try {
			setState(983);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,112,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(978);
				localVariableDeclaration();
				setState(979);
				match(SEMI);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(981);
				localTypeDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(982);
				statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LocalVariableDeclarationContext extends ParserRuleContext {
		public TerminalNode VAR() { return getToken(JavaParser.VAR, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(JavaParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public VariableDeclaratorsContext variableDeclarators() {
			return getRuleContext(VariableDeclaratorsContext.class,0);
		}
		public List<VariableModifierContext> variableModifier() {
			return getRuleContexts(VariableModifierContext.class);
		}
		public VariableModifierContext variableModifier(int i) {
			return getRuleContext(VariableModifierContext.class,i);
		}
		public LocalVariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localVariableDeclaration; }
	}

	public final LocalVariableDeclarationContext localVariableDeclaration() throws RecognitionException {
		LocalVariableDeclarationContext _localctx = new LocalVariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_localVariableDeclaration);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(988);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,113,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(985);
					variableModifier();
					}
					} 
				}
				setState(990);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,113,_ctx);
			}
			setState(999);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,114,_ctx) ) {
			case 1:
				{
				setState(991);
				match(VAR);
				setState(992);
				identifier();
				setState(993);
				match(ASSIGN);
				setState(994);
				expression(0);
				}
				break;
			case 2:
				{
				setState(996);
				typeType();
				setState(997);
				variableDeclarators();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(JavaParser.IDENTIFIER, 0); }
		public TerminalNode MODULE() { return getToken(JavaParser.MODULE, 0); }
		public TerminalNode OPEN() { return getToken(JavaParser.OPEN, 0); }
		public TerminalNode REQUIRES() { return getToken(JavaParser.REQUIRES, 0); }
		public TerminalNode EXPORTS() { return getToken(JavaParser.EXPORTS, 0); }
		public TerminalNode OPENS() { return getToken(JavaParser.OPENS, 0); }
		public TerminalNode TO() { return getToken(JavaParser.TO, 0); }
		public TerminalNode USES() { return getToken(JavaParser.USES, 0); }
		public TerminalNode PROVIDES() { return getToken(JavaParser.PROVIDES, 0); }
		public TerminalNode WITH() { return getToken(JavaParser.WITH, 0); }
		public TerminalNode TRANSITIVE() { return getToken(JavaParser.TRANSITIVE, 0); }
		public TerminalNode YIELD() { return getToken(JavaParser.YIELD, 0); }
		public TerminalNode SEALED() { return getToken(JavaParser.SEALED, 0); }
		public TerminalNode PERMITS() { return getToken(JavaParser.PERMITS, 0); }
		public TerminalNode RECORD() { return getToken(JavaParser.RECORD, 0); }
		public TerminalNode VAR() { return getToken(JavaParser.VAR, 0); }
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_identifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1001);
			_la = _input.LA(1);
			if ( !(((((_la - 51)) & ~0x3f) == 0 && ((1L << (_la - 51)) & 32767L) != 0) || _la==IDENTIFIER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeIdentifierContext extends ParserRuleContext {
		public TerminalNode IDENTIFIER() { return getToken(JavaParser.IDENTIFIER, 0); }
		public TerminalNode MODULE() { return getToken(JavaParser.MODULE, 0); }
		public TerminalNode OPEN() { return getToken(JavaParser.OPEN, 0); }
		public TerminalNode REQUIRES() { return getToken(JavaParser.REQUIRES, 0); }
		public TerminalNode EXPORTS() { return getToken(JavaParser.EXPORTS, 0); }
		public TerminalNode OPENS() { return getToken(JavaParser.OPENS, 0); }
		public TerminalNode TO() { return getToken(JavaParser.TO, 0); }
		public TerminalNode USES() { return getToken(JavaParser.USES, 0); }
		public TerminalNode PROVIDES() { return getToken(JavaParser.PROVIDES, 0); }
		public TerminalNode WITH() { return getToken(JavaParser.WITH, 0); }
		public TerminalNode TRANSITIVE() { return getToken(JavaParser.TRANSITIVE, 0); }
		public TerminalNode SEALED() { return getToken(JavaParser.SEALED, 0); }
		public TerminalNode PERMITS() { return getToken(JavaParser.PERMITS, 0); }
		public TerminalNode RECORD() { return getToken(JavaParser.RECORD, 0); }
		public TypeIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeIdentifier; }
	}

	public final TypeIdentifierContext typeIdentifier() throws RecognitionException {
		TypeIdentifierContext _localctx = new TypeIdentifierContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_typeIdentifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1003);
			_la = _input.LA(1);
			if ( !(((((_la - 51)) & ~0x3f) == 0 && ((1L << (_la - 51)) & 29695L) != 0) || _la==IDENTIFIER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LocalTypeDeclarationContext extends ParserRuleContext {
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public InterfaceDeclarationContext interfaceDeclaration() {
			return getRuleContext(InterfaceDeclarationContext.class,0);
		}
		public List<ClassOrInterfaceModifierContext> classOrInterfaceModifier() {
			return getRuleContexts(ClassOrInterfaceModifierContext.class);
		}
		public ClassOrInterfaceModifierContext classOrInterfaceModifier(int i) {
			return getRuleContext(ClassOrInterfaceModifierContext.class,i);
		}
		public LocalTypeDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_localTypeDeclaration; }
	}

	public final LocalTypeDeclarationContext localTypeDeclaration() throws RecognitionException {
		LocalTypeDeclarationContext _localctx = new LocalTypeDeclarationContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_localTypeDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1008);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -2250915050160126L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 576460752303423491L) != 0) || _la==IDENTIFIER) {
				{
				{
				setState(1005);
				classOrInterfaceModifier();
				}
				}
				setState(1010);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1013);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLASS:
				{
				setState(1011);
				classDeclaration();
				}
				break;
			case INTERFACE:
				{
				setState(1012);
				interfaceDeclaration();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public BlockContext blockLabel;
		public ExpressionContext statementExpression;
		public IdentifierContext identifierLabel;
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode ASSERT() { return getToken(JavaParser.ASSERT, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode SEMI() { return getToken(JavaParser.SEMI, 0); }
		public TerminalNode COLON() { return getToken(JavaParser.COLON, 0); }
		public TerminalNode IF() { return getToken(JavaParser.IF, 0); }
		public ParExpressionContext parExpression() {
			return getRuleContext(ParExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(JavaParser.ELSE, 0); }
		public TerminalNode FOR() { return getToken(JavaParser.FOR, 0); }
		public TerminalNode LPAREN() { return getToken(JavaParser.LPAREN, 0); }
		public ForControlContext forControl() {
			return getRuleContext(ForControlContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(JavaParser.RPAREN, 0); }
		public TerminalNode WHILE() { return getToken(JavaParser.WHILE, 0); }
		public TerminalNode DO() { return getToken(JavaParser.DO, 0); }
		public TerminalNode TRY() { return getToken(JavaParser.TRY, 0); }
		public FinallyBlockContext finallyBlock() {
			return getRuleContext(FinallyBlockContext.class,0);
		}
		public List<CatchClauseContext> catchClause() {
			return getRuleContexts(CatchClauseContext.class);
		}
		public CatchClauseContext catchClause(int i) {
			return getRuleContext(CatchClauseContext.class,i);
		}
		public ResourceSpecificationContext resourceSpecification() {
			return getRuleContext(ResourceSpecificationContext.class,0);
		}
		public TerminalNode SWITCH() { return getToken(JavaParser.SWITCH, 0); }
		public TerminalNode LBRACE() { return getToken(JavaParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(JavaParser.RBRACE, 0); }
		public List<SwitchBlockStatementGroupContext> switchBlockStatementGroup() {
			return getRuleContexts(SwitchBlockStatementGroupContext.class);
		}
		public SwitchBlockStatementGroupContext switchBlockStatementGroup(int i) {
			return getRuleContext(SwitchBlockStatementGroupContext.class,i);
		}
		public List<SwitchLabelContext> switchLabel() {
			return getRuleContexts(SwitchLabelContext.class);
		}
		public SwitchLabelContext switchLabel(int i) {
			return getRuleContext(SwitchLabelContext.class,i);
		}
		public TerminalNode SYNCHRONIZED() { return getToken(JavaParser.SYNCHRONIZED, 0); }
		public TerminalNode RETURN() { return getToken(JavaParser.RETURN, 0); }
		public TerminalNode THROW() { return getToken(JavaParser.THROW, 0); }
		public TerminalNode BREAK() { return getToken(JavaParser.BREAK, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode CONTINUE() { return getToken(JavaParser.CONTINUE, 0); }
		public TerminalNode YIELD() { return getToken(JavaParser.YIELD, 0); }
		public SwitchExpressionContext switchExpression() {
			return getRuleContext(SwitchExpressionContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_statement);
		int _la;
		try {
			int _alt;
			setState(1128);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,130,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1015);
				((StatementContext)_localctx).blockLabel = block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1016);
				match(ASSERT);
				setState(1017);
				expression(0);
				setState(1020);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==COLON) {
					{
					setState(1018);
					match(COLON);
					setState(1019);
					expression(0);
					}
				}

				setState(1022);
				match(SEMI);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1024);
				match(IF);
				setState(1025);
				parExpression();
				setState(1026);
				statement();
				setState(1029);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,118,_ctx) ) {
				case 1:
					{
					setState(1027);
					match(ELSE);
					setState(1028);
					statement();
					}
					break;
				}
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1031);
				match(FOR);
				setState(1032);
				match(LPAREN);
				setState(1033);
				forControl();
				setState(1034);
				match(RPAREN);
				setState(1035);
				statement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1037);
				match(WHILE);
				setState(1038);
				parExpression();
				setState(1039);
				statement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1041);
				match(DO);
				setState(1042);
				statement();
				setState(1043);
				match(WHILE);
				setState(1044);
				parExpression();
				setState(1045);
				match(SEMI);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1047);
				match(TRY);
				setState(1048);
				block();
				setState(1058);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case CATCH:
					{
					setState(1050); 
					_errHandler.sync(this);
					_la = _input.LA(1);
					do {
						{
						{
						setState(1049);
						catchClause();
						}
						}
						setState(1052); 
						_errHandler.sync(this);
						_la = _input.LA(1);
					} while ( _la==CATCH );
					setState(1055);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==FINALLY) {
						{
						setState(1054);
						finallyBlock();
						}
					}

					}
					break;
				case FINALLY:
					{
					setState(1057);
					finallyBlock();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1060);
				match(TRY);
				setState(1061);
				resourceSpecification();
				setState(1062);
				block();
				setState(1066);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CATCH) {
					{
					{
					setState(1063);
					catchClause();
					}
					}
					setState(1068);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1070);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FINALLY) {
					{
					setState(1069);
					finallyBlock();
					}
				}

				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1072);
				match(SWITCH);
				setState(1073);
				parExpression();
				setState(1074);
				match(LBRACE);
				setState(1078);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,124,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1075);
						switchBlockStatementGroup();
						}
						} 
					}
					setState(1080);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,124,_ctx);
				}
				setState(1084);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CASE || _la==DEFAULT) {
					{
					{
					setState(1081);
					switchLabel();
					}
					}
					setState(1086);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1087);
				match(RBRACE);
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1089);
				match(SYNCHRONIZED);
				setState(1090);
				parExpression();
				setState(1091);
				block();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(1093);
				match(RETURN);
				setState(1095);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 3)) & ~0x3f) == 0 && ((1L << (_la - 3)) & 9223127275610966053L) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & -9151314313938464769L) != 0)) {
					{
					setState(1094);
					expression(0);
					}
				}

				setState(1097);
				match(SEMI);
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(1098);
				match(THROW);
				setState(1099);
				expression(0);
				setState(1100);
				match(SEMI);
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(1102);
				match(BREAK);
				setState(1104);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 51)) & ~0x3f) == 0 && ((1L << (_la - 51)) & 32767L) != 0) || _la==IDENTIFIER) {
					{
					setState(1103);
					identifier();
					}
				}

				setState(1106);
				match(SEMI);
				}
				break;
			case 14:
				enterOuterAlt(_localctx, 14);
				{
				setState(1107);
				match(CONTINUE);
				setState(1109);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 51)) & ~0x3f) == 0 && ((1L << (_la - 51)) & 32767L) != 0) || _la==IDENTIFIER) {
					{
					setState(1108);
					identifier();
					}
				}

				setState(1111);
				match(SEMI);
				}
				break;
			case 15:
				enterOuterAlt(_localctx, 15);
				{
				setState(1112);
				match(YIELD);
				setState(1113);
				expression(0);
				setState(1114);
				match(SEMI);
				}
				break;
			case 16:
				enterOuterAlt(_localctx, 16);
				{
				setState(1116);
				match(SEMI);
				}
				break;
			case 17:
				enterOuterAlt(_localctx, 17);
				{
				setState(1117);
				((StatementContext)_localctx).statementExpression = expression(0);
				setState(1118);
				match(SEMI);
				}
				break;
			case 18:
				enterOuterAlt(_localctx, 18);
				{
				setState(1120);
				switchExpression();
				setState(1122);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,129,_ctx) ) {
				case 1:
					{
					setState(1121);
					match(SEMI);
					}
					break;
				}
				}
				break;
			case 19:
				enterOuterAlt(_localctx, 19);
				{
				setState(1124);
				((StatementContext)_localctx).identifierLabel = identifier();
				setState(1125);
				match(COLON);
				setState(1126);
				statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CatchClauseContext extends ParserRuleContext {
		public TerminalNode CATCH() { return getToken(JavaParser.CATCH, 0); }
		public TerminalNode LPAREN() { return getToken(JavaParser.LPAREN, 0); }
		public CatchTypeContext catchType() {
			return getRuleContext(CatchTypeContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(JavaParser.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<VariableModifierContext> variableModifier() {
			return getRuleContexts(VariableModifierContext.class);
		}
		public VariableModifierContext variableModifier(int i) {
			return getRuleContext(VariableModifierContext.class,i);
		}
		public CatchClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catchClause; }
	}

	public final CatchClauseContext catchClause() throws RecognitionException {
		CatchClauseContext _localctx = new CatchClauseContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_catchClause);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1130);
			match(CATCH);
			setState(1131);
			match(LPAREN);
			setState(1135);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,131,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1132);
					variableModifier();
					}
					} 
				}
				setState(1137);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,131,_ctx);
			}
			setState(1138);
			catchType();
			setState(1139);
			identifier();
			setState(1140);
			match(RPAREN);
			setState(1141);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CatchTypeContext extends ParserRuleContext {
		public List<QualifiedNameContext> qualifiedName() {
			return getRuleContexts(QualifiedNameContext.class);
		}
		public QualifiedNameContext qualifiedName(int i) {
			return getRuleContext(QualifiedNameContext.class,i);
		}
		public List<TerminalNode> BITOR() { return getTokens(JavaParser.BITOR); }
		public TerminalNode BITOR(int i) {
			return getToken(JavaParser.BITOR, i);
		}
		public CatchTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catchType; }
	}

	public final CatchTypeContext catchType() throws RecognitionException {
		CatchTypeContext _localctx = new CatchTypeContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_catchType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1143);
			qualifiedName();
			setState(1148);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==BITOR) {
				{
				{
				setState(1144);
				match(BITOR);
				setState(1145);
				qualifiedName();
				}
				}
				setState(1150);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FinallyBlockContext extends ParserRuleContext {
		public TerminalNode FINALLY() { return getToken(JavaParser.FINALLY, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FinallyBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finallyBlock; }
	}

	public final FinallyBlockContext finallyBlock() throws RecognitionException {
		FinallyBlockContext _localctx = new FinallyBlockContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_finallyBlock);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1151);
			match(FINALLY);
			setState(1152);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ResourceSpecificationContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(JavaParser.LPAREN, 0); }
		public ResourcesContext resources() {
			return getRuleContext(ResourcesContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(JavaParser.RPAREN, 0); }
		public TerminalNode SEMI() { return getToken(JavaParser.SEMI, 0); }
		public ResourceSpecificationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resourceSpecification; }
	}

	public final ResourceSpecificationContext resourceSpecification() throws RecognitionException {
		ResourceSpecificationContext _localctx = new ResourceSpecificationContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_resourceSpecification);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1154);
			match(LPAREN);
			setState(1155);
			resources();
			setState(1157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==SEMI) {
				{
				setState(1156);
				match(SEMI);
				}
			}

			setState(1159);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ResourcesContext extends ParserRuleContext {
		public List<ResourceContext> resource() {
			return getRuleContexts(ResourceContext.class);
		}
		public ResourceContext resource(int i) {
			return getRuleContext(ResourceContext.class,i);
		}
		public List<TerminalNode> SEMI() { return getTokens(JavaParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(JavaParser.SEMI, i);
		}
		public ResourcesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resources; }
	}

	public final ResourcesContext resources() throws RecognitionException {
		ResourcesContext _localctx = new ResourcesContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_resources);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1161);
			resource();
			setState(1166);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,134,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1162);
					match(SEMI);
					setState(1163);
					resource();
					}
					} 
				}
				setState(1168);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,134,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ResourceContext extends ParserRuleContext {
		public TerminalNode ASSIGN() { return getToken(JavaParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ClassOrInterfaceTypeContext classOrInterfaceType() {
			return getRuleContext(ClassOrInterfaceTypeContext.class,0);
		}
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public TerminalNode VAR() { return getToken(JavaParser.VAR, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<VariableModifierContext> variableModifier() {
			return getRuleContexts(VariableModifierContext.class);
		}
		public VariableModifierContext variableModifier(int i) {
			return getRuleContext(VariableModifierContext.class,i);
		}
		public QualifiedNameContext qualifiedName() {
			return getRuleContext(QualifiedNameContext.class,0);
		}
		public ResourceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_resource; }
	}

	public final ResourceContext resource() throws RecognitionException {
		ResourceContext _localctx = new ResourceContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_resource);
		try {
			int _alt;
			setState(1186);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,137,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1172);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,135,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1169);
						variableModifier();
						}
						} 
					}
					setState(1174);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,135,_ctx);
				}
				setState(1180);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,136,_ctx) ) {
				case 1:
					{
					setState(1175);
					classOrInterfaceType();
					setState(1176);
					variableDeclaratorId();
					}
					break;
				case 2:
					{
					setState(1178);
					match(VAR);
					setState(1179);
					identifier();
					}
					break;
				}
				setState(1182);
				match(ASSIGN);
				setState(1183);
				expression(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1185);
				qualifiedName();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SwitchBlockStatementGroupContext extends ParserRuleContext {
		public List<SwitchLabelContext> switchLabel() {
			return getRuleContexts(SwitchLabelContext.class);
		}
		public SwitchLabelContext switchLabel(int i) {
			return getRuleContext(SwitchLabelContext.class,i);
		}
		public List<BlockStatementContext> blockStatement() {
			return getRuleContexts(BlockStatementContext.class);
		}
		public BlockStatementContext blockStatement(int i) {
			return getRuleContext(BlockStatementContext.class,i);
		}
		public SwitchBlockStatementGroupContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchBlockStatementGroup; }
	}

	public final SwitchBlockStatementGroupContext switchBlockStatementGroup() throws RecognitionException {
		SwitchBlockStatementGroupContext _localctx = new SwitchBlockStatementGroupContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_switchBlockStatementGroup);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1189); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1188);
				switchLabel();
				}
				}
				setState(1191); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==CASE || _la==DEFAULT );
			setState(1194); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1193);
				blockStatement();
				}
				}
				setState(1196); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & -668508564985026L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 576461783331602427L) != 0) || _la==IDENTIFIER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SwitchLabelContext extends ParserRuleContext {
		public ExpressionContext constantExpression;
		public Token enumConstantName;
		public IdentifierContext varName;
		public TerminalNode CASE() { return getToken(JavaParser.CASE, 0); }
		public TerminalNode COLON() { return getToken(JavaParser.COLON, 0); }
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode IDENTIFIER() { return getToken(JavaParser.IDENTIFIER, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode DEFAULT() { return getToken(JavaParser.DEFAULT, 0); }
		public SwitchLabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchLabel; }
	}

	public final SwitchLabelContext switchLabel() throws RecognitionException {
		SwitchLabelContext _localctx = new SwitchLabelContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_switchLabel);
		try {
			setState(1209);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CASE:
				enterOuterAlt(_localctx, 1);
				{
				setState(1198);
				match(CASE);
				setState(1204);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,140,_ctx) ) {
				case 1:
					{
					setState(1199);
					((SwitchLabelContext)_localctx).constantExpression = expression(0);
					}
					break;
				case 2:
					{
					setState(1200);
					((SwitchLabelContext)_localctx).enumConstantName = match(IDENTIFIER);
					}
					break;
				case 3:
					{
					setState(1201);
					typeType();
					setState(1202);
					((SwitchLabelContext)_localctx).varName = identifier();
					}
					break;
				}
				setState(1206);
				match(COLON);
				}
				break;
			case DEFAULT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1207);
				match(DEFAULT);
				setState(1208);
				match(COLON);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForControlContext extends ParserRuleContext {
		public ExpressionListContext forUpdate;
		public EnhancedForControlContext enhancedForControl() {
			return getRuleContext(EnhancedForControlContext.class,0);
		}
		public List<TerminalNode> SEMI() { return getTokens(JavaParser.SEMI); }
		public TerminalNode SEMI(int i) {
			return getToken(JavaParser.SEMI, i);
		}
		public ForInitContext forInit() {
			return getRuleContext(ForInitContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public ForControlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forControl; }
	}

	public final ForControlContext forControl() throws RecognitionException {
		ForControlContext _localctx = new ForControlContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_forControl);
		int _la;
		try {
			setState(1223);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,145,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1211);
				enhancedForControl();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1213);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 3)) & ~0x3f) == 0 && ((1L << (_la - 3)) & 9223127275610998821L) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & -9151314313938464769L) != 0)) {
					{
					setState(1212);
					forInit();
					}
				}

				setState(1215);
				match(SEMI);
				setState(1217);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 3)) & ~0x3f) == 0 && ((1L << (_la - 3)) & 9223127275610966053L) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & -9151314313938464769L) != 0)) {
					{
					setState(1216);
					expression(0);
					}
				}

				setState(1219);
				match(SEMI);
				setState(1221);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 3)) & ~0x3f) == 0 && ((1L << (_la - 3)) & 9223127275610966053L) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & -9151314313938464769L) != 0)) {
					{
					setState(1220);
					((ForControlContext)_localctx).forUpdate = expressionList();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForInitContext extends ParserRuleContext {
		public LocalVariableDeclarationContext localVariableDeclaration() {
			return getRuleContext(LocalVariableDeclarationContext.class,0);
		}
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public ForInitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forInit; }
	}

	public final ForInitContext forInit() throws RecognitionException {
		ForInitContext _localctx = new ForInitContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_forInit);
		try {
			setState(1227);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,146,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1225);
				localVariableDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1226);
				expressionList();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EnhancedForControlContext extends ParserRuleContext {
		public VariableDeclaratorIdContext variableDeclaratorId() {
			return getRuleContext(VariableDeclaratorIdContext.class,0);
		}
		public TerminalNode COLON() { return getToken(JavaParser.COLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public TerminalNode VAR() { return getToken(JavaParser.VAR, 0); }
		public List<VariableModifierContext> variableModifier() {
			return getRuleContexts(VariableModifierContext.class);
		}
		public VariableModifierContext variableModifier(int i) {
			return getRuleContext(VariableModifierContext.class,i);
		}
		public EnhancedForControlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enhancedForControl; }
	}

	public final EnhancedForControlContext enhancedForControl() throws RecognitionException {
		EnhancedForControlContext _localctx = new EnhancedForControlContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_enhancedForControl);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1232);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,147,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1229);
					variableModifier();
					}
					} 
				}
				setState(1234);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,147,_ctx);
			}
			setState(1237);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,148,_ctx) ) {
			case 1:
				{
				setState(1235);
				typeType();
				}
				break;
			case 2:
				{
				setState(1236);
				match(VAR);
				}
				break;
			}
			setState(1239);
			variableDeclaratorId();
			setState(1240);
			match(COLON);
			setState(1241);
			expression(0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParExpressionContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(JavaParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(JavaParser.RPAREN, 0); }
		public ParExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parExpression; }
	}

	public final ParExpressionContext parExpression() throws RecognitionException {
		ParExpressionContext _localctx = new ParExpressionContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_parExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1243);
			match(LPAREN);
			setState(1244);
			expression(0);
			setState(1245);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(JavaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JavaParser.COMMA, i);
		}
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1247);
			expression(0);
			setState(1252);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1248);
				match(COMMA);
				setState(1249);
				expression(0);
				}
				}
				setState(1254);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MethodCallContext extends ParserRuleContext {
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode THIS() { return getToken(JavaParser.THIS, 0); }
		public TerminalNode SUPER() { return getToken(JavaParser.SUPER, 0); }
		public MethodCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodCall; }
	}

	public final MethodCallContext methodCall() throws RecognitionException {
		MethodCallContext _localctx = new MethodCallContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_methodCall);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1258);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MODULE:
			case OPEN:
			case REQUIRES:
			case EXPORTS:
			case OPENS:
			case TO:
			case USES:
			case PROVIDES:
			case WITH:
			case TRANSITIVE:
			case VAR:
			case YIELD:
			case RECORD:
			case SEALED:
			case PERMITS:
			case IDENTIFIER:
				{
				setState(1255);
				identifier();
				}
				break;
			case THIS:
				{
				setState(1256);
				match(THIS);
				}
				break;
			case SUPER:
				{
				setState(1257);
				match(SUPER);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1260);
			arguments();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public Token prefix;
		public Token bop;
		public Token postfix;
		public PrimaryContext primary() {
			return getRuleContext(PrimaryContext.class,0);
		}
		public MethodCallContext methodCall() {
			return getRuleContext(MethodCallContext.class,0);
		}
		public List<TypeTypeContext> typeType() {
			return getRuleContexts(TypeTypeContext.class);
		}
		public TypeTypeContext typeType(int i) {
			return getRuleContext(TypeTypeContext.class,i);
		}
		public TerminalNode COLONCOLON() { return getToken(JavaParser.COLONCOLON, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TerminalNode NEW() { return getToken(JavaParser.NEW, 0); }
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public ClassTypeContext classType() {
			return getRuleContext(ClassTypeContext.class,0);
		}
		public SwitchExpressionContext switchExpression() {
			return getRuleContext(SwitchExpressionContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ADD() { return getToken(JavaParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(JavaParser.SUB, 0); }
		public TerminalNode INC() { return getToken(JavaParser.INC, 0); }
		public TerminalNode DEC() { return getToken(JavaParser.DEC, 0); }
		public TerminalNode TILDE() { return getToken(JavaParser.TILDE, 0); }
		public TerminalNode BANG() { return getToken(JavaParser.BANG, 0); }
		public TerminalNode LPAREN() { return getToken(JavaParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(JavaParser.RPAREN, 0); }
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public List<TerminalNode> BITAND() { return getTokens(JavaParser.BITAND); }
		public TerminalNode BITAND(int i) {
			return getToken(JavaParser.BITAND, i);
		}
		public CreatorContext creator() {
			return getRuleContext(CreatorContext.class,0);
		}
		public LambdaExpressionContext lambdaExpression() {
			return getRuleContext(LambdaExpressionContext.class,0);
		}
		public TerminalNode MUL() { return getToken(JavaParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(JavaParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(JavaParser.MOD, 0); }
		public List<TerminalNode> LT() { return getTokens(JavaParser.LT); }
		public TerminalNode LT(int i) {
			return getToken(JavaParser.LT, i);
		}
		public List<TerminalNode> GT() { return getTokens(JavaParser.GT); }
		public TerminalNode GT(int i) {
			return getToken(JavaParser.GT, i);
		}
		public TerminalNode LE() { return getToken(JavaParser.LE, 0); }
		public TerminalNode GE() { return getToken(JavaParser.GE, 0); }
		public TerminalNode EQUAL() { return getToken(JavaParser.EQUAL, 0); }
		public TerminalNode NOTEQUAL() { return getToken(JavaParser.NOTEQUAL, 0); }
		public TerminalNode CARET() { return getToken(JavaParser.CARET, 0); }
		public TerminalNode BITOR() { return getToken(JavaParser.BITOR, 0); }
		public TerminalNode AND() { return getToken(JavaParser.AND, 0); }
		public TerminalNode OR() { return getToken(JavaParser.OR, 0); }
		public TerminalNode COLON() { return getToken(JavaParser.COLON, 0); }
		public TerminalNode QUESTION() { return getToken(JavaParser.QUESTION, 0); }
		public TerminalNode ASSIGN() { return getToken(JavaParser.ASSIGN, 0); }
		public TerminalNode ADD_ASSIGN() { return getToken(JavaParser.ADD_ASSIGN, 0); }
		public TerminalNode SUB_ASSIGN() { return getToken(JavaParser.SUB_ASSIGN, 0); }
		public TerminalNode MUL_ASSIGN() { return getToken(JavaParser.MUL_ASSIGN, 0); }
		public TerminalNode DIV_ASSIGN() { return getToken(JavaParser.DIV_ASSIGN, 0); }
		public TerminalNode AND_ASSIGN() { return getToken(JavaParser.AND_ASSIGN, 0); }
		public TerminalNode OR_ASSIGN() { return getToken(JavaParser.OR_ASSIGN, 0); }
		public TerminalNode XOR_ASSIGN() { return getToken(JavaParser.XOR_ASSIGN, 0); }
		public TerminalNode RSHIFT_ASSIGN() { return getToken(JavaParser.RSHIFT_ASSIGN, 0); }
		public TerminalNode URSHIFT_ASSIGN() { return getToken(JavaParser.URSHIFT_ASSIGN, 0); }
		public TerminalNode LSHIFT_ASSIGN() { return getToken(JavaParser.LSHIFT_ASSIGN, 0); }
		public TerminalNode MOD_ASSIGN() { return getToken(JavaParser.MOD_ASSIGN, 0); }
		public TerminalNode LBRACK() { return getToken(JavaParser.LBRACK, 0); }
		public TerminalNode RBRACK() { return getToken(JavaParser.RBRACK, 0); }
		public TerminalNode DOT() { return getToken(JavaParser.DOT, 0); }
		public TerminalNode THIS() { return getToken(JavaParser.THIS, 0); }
		public InnerCreatorContext innerCreator() {
			return getRuleContext(InnerCreatorContext.class,0);
		}
		public TerminalNode SUPER() { return getToken(JavaParser.SUPER, 0); }
		public SuperSuffixContext superSuffix() {
			return getRuleContext(SuperSuffixContext.class,0);
		}
		public ExplicitGenericInvocationContext explicitGenericInvocation() {
			return getRuleContext(ExplicitGenericInvocationContext.class,0);
		}
		public NonWildcardTypeArgumentsContext nonWildcardTypeArguments() {
			return getRuleContext(NonWildcardTypeArgumentsContext.class,0);
		}
		public TerminalNode INSTANCEOF() { return getToken(JavaParser.INSTANCEOF, 0); }
		public PatternContext pattern() {
			return getRuleContext(PatternContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 188;
		enterRecursionRule(_localctx, 188, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1305);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,156,_ctx) ) {
			case 1:
				{
				setState(1263);
				primary();
				}
				break;
			case 2:
				{
				setState(1264);
				methodCall();
				}
				break;
			case 3:
				{
				setState(1265);
				typeType();
				setState(1266);
				match(COLONCOLON);
				setState(1272);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case MODULE:
				case OPEN:
				case REQUIRES:
				case EXPORTS:
				case OPENS:
				case TO:
				case USES:
				case PROVIDES:
				case WITH:
				case TRANSITIVE:
				case VAR:
				case YIELD:
				case RECORD:
				case SEALED:
				case PERMITS:
				case LT:
				case IDENTIFIER:
					{
					setState(1268);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==LT) {
						{
						setState(1267);
						typeArguments();
						}
					}

					setState(1270);
					identifier();
					}
					break;
				case NEW:
					{
					setState(1271);
					match(NEW);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 4:
				{
				setState(1274);
				classType();
				setState(1275);
				match(COLONCOLON);
				setState(1277);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(1276);
					typeArguments();
					}
				}

				setState(1279);
				match(NEW);
				}
				break;
			case 5:
				{
				setState(1281);
				switchExpression();
				}
				break;
			case 6:
				{
				setState(1282);
				((ExpressionContext)_localctx).prefix = _input.LT(1);
				_la = _input.LA(1);
				if ( !(((((_la - 90)) & ~0x3f) == 0 && ((1L << (_la - 90)) & 15363L) != 0)) ) {
					((ExpressionContext)_localctx).prefix = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1283);
				expression(17);
				}
				break;
			case 7:
				{
				setState(1284);
				match(LPAREN);
				setState(1288);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,154,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1285);
						annotation();
						}
						} 
					}
					setState(1290);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,154,_ctx);
				}
				setState(1291);
				typeType();
				setState(1296);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==BITAND) {
					{
					{
					setState(1292);
					match(BITAND);
					setState(1293);
					typeType();
					}
					}
					setState(1298);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1299);
				match(RPAREN);
				setState(1300);
				expression(16);
				}
				break;
			case 8:
				{
				setState(1302);
				match(NEW);
				setState(1303);
				creator();
				}
				break;
			case 9:
				{
				setState(1304);
				lambdaExpression();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(1390);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,163,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(1388);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,162,_ctx) ) {
					case 1:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1307);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(1308);
						((ExpressionContext)_localctx).bop = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 104)) & ~0x3f) == 0 && ((1L << (_la - 104)) & 35L) != 0)) ) {
							((ExpressionContext)_localctx).bop = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1309);
						expression(15);
						}
						break;
					case 2:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1310);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(1311);
						((ExpressionContext)_localctx).bop = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((ExpressionContext)_localctx).bop = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1312);
						expression(14);
						}
						break;
					case 3:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1313);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(1321);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,157,_ctx) ) {
						case 1:
							{
							setState(1314);
							match(LT);
							setState(1315);
							match(LT);
							}
							break;
						case 2:
							{
							setState(1316);
							match(GT);
							setState(1317);
							match(GT);
							setState(1318);
							match(GT);
							}
							break;
						case 3:
							{
							setState(1319);
							match(GT);
							setState(1320);
							match(GT);
							}
							break;
						}
						setState(1323);
						expression(13);
						}
						break;
					case 4:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1324);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(1325);
						((ExpressionContext)_localctx).bop = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 88)) & ~0x3f) == 0 && ((1L << (_la - 88)) & 387L) != 0)) ) {
							((ExpressionContext)_localctx).bop = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1326);
						expression(12);
						}
						break;
					case 5:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1327);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(1328);
						((ExpressionContext)_localctx).bop = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==EQUAL || _la==NOTEQUAL) ) {
							((ExpressionContext)_localctx).bop = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1329);
						expression(10);
						}
						break;
					case 6:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1330);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(1331);
						((ExpressionContext)_localctx).bop = match(BITAND);
						setState(1332);
						expression(9);
						}
						break;
					case 7:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1333);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(1334);
						((ExpressionContext)_localctx).bop = match(CARET);
						setState(1335);
						expression(8);
						}
						break;
					case 8:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1336);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(1337);
						((ExpressionContext)_localctx).bop = match(BITOR);
						setState(1338);
						expression(7);
						}
						break;
					case 9:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1339);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(1340);
						((ExpressionContext)_localctx).bop = match(AND);
						setState(1341);
						expression(6);
						}
						break;
					case 10:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1342);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(1343);
						((ExpressionContext)_localctx).bop = match(OR);
						setState(1344);
						expression(5);
						}
						break;
					case 11:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1345);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(1346);
						((ExpressionContext)_localctx).bop = match(QUESTION);
						setState(1347);
						expression(0);
						setState(1348);
						match(COLON);
						setState(1349);
						expression(3);
						}
						break;
					case 12:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1351);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(1352);
						((ExpressionContext)_localctx).bop = _input.LT(1);
						_la = _input.LA(1);
						if ( !(((((_la - 87)) & ~0x3f) == 0 && ((1L << (_la - 87)) & 17171480577L) != 0)) ) {
							((ExpressionContext)_localctx).bop = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(1353);
						expression(2);
						}
						break;
					case 13:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1354);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(1355);
						match(LBRACK);
						setState(1356);
						expression(0);
						setState(1357);
						match(RBRACK);
						}
						break;
					case 14:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1359);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(1360);
						((ExpressionContext)_localctx).bop = match(DOT);
						setState(1372);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,159,_ctx) ) {
						case 1:
							{
							setState(1361);
							identifier();
							}
							break;
						case 2:
							{
							setState(1362);
							methodCall();
							}
							break;
						case 3:
							{
							setState(1363);
							match(THIS);
							}
							break;
						case 4:
							{
							setState(1364);
							match(NEW);
							setState(1366);
							_errHandler.sync(this);
							_la = _input.LA(1);
							if (_la==LT) {
								{
								setState(1365);
								nonWildcardTypeArguments();
								}
							}

							setState(1368);
							innerCreator();
							}
							break;
						case 5:
							{
							setState(1369);
							match(SUPER);
							setState(1370);
							superSuffix();
							}
							break;
						case 6:
							{
							setState(1371);
							explicitGenericInvocation();
							}
							break;
						}
						}
						break;
					case 15:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1374);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(1375);
						match(COLONCOLON);
						setState(1377);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if (_la==LT) {
							{
							setState(1376);
							typeArguments();
							}
						}

						setState(1379);
						identifier();
						}
						break;
					case 16:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1380);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(1381);
						((ExpressionContext)_localctx).postfix = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==INC || _la==DEC) ) {
							((ExpressionContext)_localctx).postfix = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					case 17:
						{
						_localctx = new ExpressionContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(1382);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(1383);
						((ExpressionContext)_localctx).bop = match(INSTANCEOF);
						setState(1386);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,161,_ctx) ) {
						case 1:
							{
							setState(1384);
							typeType();
							}
							break;
						case 2:
							{
							setState(1385);
							pattern();
							}
							break;
						}
						}
						break;
					}
					} 
				}
				setState(1392);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,163,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PatternContext extends ParserRuleContext {
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<VariableModifierContext> variableModifier() {
			return getRuleContexts(VariableModifierContext.class);
		}
		public VariableModifierContext variableModifier(int i) {
			return getRuleContext(VariableModifierContext.class,i);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public PatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pattern; }
	}

	public final PatternContext pattern() throws RecognitionException {
		PatternContext _localctx = new PatternContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_pattern);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1396);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,164,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1393);
					variableModifier();
					}
					} 
				}
				setState(1398);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,164,_ctx);
			}
			setState(1399);
			typeType();
			setState(1403);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,165,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1400);
					annotation();
					}
					} 
				}
				setState(1405);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,165,_ctx);
			}
			setState(1406);
			identifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LambdaExpressionContext extends ParserRuleContext {
		public LambdaParametersContext lambdaParameters() {
			return getRuleContext(LambdaParametersContext.class,0);
		}
		public TerminalNode ARROW() { return getToken(JavaParser.ARROW, 0); }
		public LambdaBodyContext lambdaBody() {
			return getRuleContext(LambdaBodyContext.class,0);
		}
		public LambdaExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaExpression; }
	}

	public final LambdaExpressionContext lambdaExpression() throws RecognitionException {
		LambdaExpressionContext _localctx = new LambdaExpressionContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_lambdaExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1408);
			lambdaParameters();
			setState(1409);
			match(ARROW);
			setState(1410);
			lambdaBody();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LambdaParametersContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public TerminalNode LPAREN() { return getToken(JavaParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(JavaParser.RPAREN, 0); }
		public FormalParameterListContext formalParameterList() {
			return getRuleContext(FormalParameterListContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(JavaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JavaParser.COMMA, i);
		}
		public LambdaLVTIListContext lambdaLVTIList() {
			return getRuleContext(LambdaLVTIListContext.class,0);
		}
		public LambdaParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaParameters; }
	}

	public final LambdaParametersContext lambdaParameters() throws RecognitionException {
		LambdaParametersContext _localctx = new LambdaParametersContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_lambdaParameters);
		int _la;
		try {
			setState(1434);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,169,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1412);
				identifier();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1413);
				match(LPAREN);
				setState(1415);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 3)) & ~0x3f) == 0 && ((1L << (_la - 3)) & 9223090579141986341L) != 0) || _la==AT || _la==IDENTIFIER) {
					{
					setState(1414);
					formalParameterList();
					}
				}

				setState(1417);
				match(RPAREN);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1418);
				match(LPAREN);
				setState(1419);
				identifier();
				setState(1424);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==COMMA) {
					{
					{
					setState(1420);
					match(COMMA);
					setState(1421);
					identifier();
					}
					}
					setState(1426);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1427);
				match(RPAREN);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1429);
				match(LPAREN);
				setState(1431);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (((((_la - 18)) & ~0x3f) == 0 && ((1L << (_la - 18)) & 281466386776065L) != 0) || _la==AT || _la==IDENTIFIER) {
					{
					setState(1430);
					lambdaLVTIList();
					}
				}

				setState(1433);
				match(RPAREN);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LambdaBodyContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public LambdaBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaBody; }
	}

	public final LambdaBodyContext lambdaBody() throws RecognitionException {
		LambdaBodyContext _localctx = new LambdaBodyContext(_ctx, getState());
		enterRule(_localctx, 196, RULE_lambdaBody);
		try {
			setState(1438);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case NEW:
			case SHORT:
			case SUPER:
			case SWITCH:
			case THIS:
			case VOID:
			case MODULE:
			case OPEN:
			case REQUIRES:
			case EXPORTS:
			case OPENS:
			case TO:
			case USES:
			case PROVIDES:
			case WITH:
			case TRANSITIVE:
			case VAR:
			case YIELD:
			case RECORD:
			case SEALED:
			case PERMITS:
			case DECIMAL_LITERAL:
			case HEX_LITERAL:
			case OCT_LITERAL:
			case BINARY_LITERAL:
			case FLOAT_LITERAL:
			case HEX_FLOAT_LITERAL:
			case BOOL_LITERAL:
			case CHAR_LITERAL:
			case STRING_LITERAL:
			case TEXT_BLOCK:
			case NULL_LITERAL:
			case LPAREN:
			case LT:
			case BANG:
			case TILDE:
			case INC:
			case DEC:
			case ADD:
			case SUB:
			case AT:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(1436);
				expression(0);
				}
				break;
			case LBRACE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1437);
				block();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(JavaParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(JavaParser.RPAREN, 0); }
		public TerminalNode THIS() { return getToken(JavaParser.THIS, 0); }
		public TerminalNode SUPER() { return getToken(JavaParser.SUPER, 0); }
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TypeTypeOrVoidContext typeTypeOrVoid() {
			return getRuleContext(TypeTypeOrVoidContext.class,0);
		}
		public TerminalNode DOT() { return getToken(JavaParser.DOT, 0); }
		public TerminalNode CLASS() { return getToken(JavaParser.CLASS, 0); }
		public NonWildcardTypeArgumentsContext nonWildcardTypeArguments() {
			return getRuleContext(NonWildcardTypeArgumentsContext.class,0);
		}
		public ExplicitGenericInvocationSuffixContext explicitGenericInvocationSuffix() {
			return getRuleContext(ExplicitGenericInvocationSuffixContext.class,0);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public PrimaryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primary; }
	}

	public final PrimaryContext primary() throws RecognitionException {
		PrimaryContext _localctx = new PrimaryContext(_ctx, getState());
		enterRule(_localctx, 198, RULE_primary);
		try {
			setState(1458);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,172,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1440);
				match(LPAREN);
				setState(1441);
				expression(0);
				setState(1442);
				match(RPAREN);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1444);
				match(THIS);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1445);
				match(SUPER);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1446);
				literal();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1447);
				identifier();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1448);
				typeTypeOrVoid();
				setState(1449);
				match(DOT);
				setState(1450);
				match(CLASS);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1452);
				nonWildcardTypeArguments();
				setState(1456);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case SUPER:
				case MODULE:
				case OPEN:
				case REQUIRES:
				case EXPORTS:
				case OPENS:
				case TO:
				case USES:
				case PROVIDES:
				case WITH:
				case TRANSITIVE:
				case VAR:
				case YIELD:
				case RECORD:
				case SEALED:
				case PERMITS:
				case IDENTIFIER:
					{
					setState(1453);
					explicitGenericInvocationSuffix();
					}
					break;
				case THIS:
					{
					setState(1454);
					match(THIS);
					setState(1455);
					arguments();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SwitchExpressionContext extends ParserRuleContext {
		public TerminalNode SWITCH() { return getToken(JavaParser.SWITCH, 0); }
		public ParExpressionContext parExpression() {
			return getRuleContext(ParExpressionContext.class,0);
		}
		public TerminalNode LBRACE() { return getToken(JavaParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(JavaParser.RBRACE, 0); }
		public List<SwitchLabeledRuleContext> switchLabeledRule() {
			return getRuleContexts(SwitchLabeledRuleContext.class);
		}
		public SwitchLabeledRuleContext switchLabeledRule(int i) {
			return getRuleContext(SwitchLabeledRuleContext.class,i);
		}
		public SwitchExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchExpression; }
	}

	public final SwitchExpressionContext switchExpression() throws RecognitionException {
		SwitchExpressionContext _localctx = new SwitchExpressionContext(_ctx, getState());
		enterRule(_localctx, 200, RULE_switchExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1460);
			match(SWITCH);
			setState(1461);
			parExpression();
			setState(1462);
			match(LBRACE);
			setState(1466);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CASE || _la==DEFAULT) {
				{
				{
				setState(1463);
				switchLabeledRule();
				}
				}
				setState(1468);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1469);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SwitchLabeledRuleContext extends ParserRuleContext {
		public TerminalNode CASE() { return getToken(JavaParser.CASE, 0); }
		public SwitchRuleOutcomeContext switchRuleOutcome() {
			return getRuleContext(SwitchRuleOutcomeContext.class,0);
		}
		public TerminalNode ARROW() { return getToken(JavaParser.ARROW, 0); }
		public TerminalNode COLON() { return getToken(JavaParser.COLON, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public TerminalNode NULL_LITERAL() { return getToken(JavaParser.NULL_LITERAL, 0); }
		public GuardedPatternContext guardedPattern() {
			return getRuleContext(GuardedPatternContext.class,0);
		}
		public TerminalNode DEFAULT() { return getToken(JavaParser.DEFAULT, 0); }
		public SwitchLabeledRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchLabeledRule; }
	}

	public final SwitchLabeledRuleContext switchLabeledRule() throws RecognitionException {
		SwitchLabeledRuleContext _localctx = new SwitchLabeledRuleContext(_ctx, getState());
		enterRule(_localctx, 202, RULE_switchLabeledRule);
		int _la;
		try {
			setState(1482);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CASE:
				enterOuterAlt(_localctx, 1);
				{
				setState(1471);
				match(CASE);
				setState(1475);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,174,_ctx) ) {
				case 1:
					{
					setState(1472);
					expressionList();
					}
					break;
				case 2:
					{
					setState(1473);
					match(NULL_LITERAL);
					}
					break;
				case 3:
					{
					setState(1474);
					guardedPattern(0);
					}
					break;
				}
				setState(1477);
				_la = _input.LA(1);
				if ( !(_la==COLON || _la==ARROW) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1478);
				switchRuleOutcome();
				}
				break;
			case DEFAULT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1479);
				match(DEFAULT);
				setState(1480);
				_la = _input.LA(1);
				if ( !(_la==COLON || _la==ARROW) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1481);
				switchRuleOutcome();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GuardedPatternContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(JavaParser.LPAREN, 0); }
		public GuardedPatternContext guardedPattern() {
			return getRuleContext(GuardedPatternContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(JavaParser.RPAREN, 0); }
		public TypeTypeContext typeType() {
			return getRuleContext(TypeTypeContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public List<VariableModifierContext> variableModifier() {
			return getRuleContexts(VariableModifierContext.class);
		}
		public VariableModifierContext variableModifier(int i) {
			return getRuleContext(VariableModifierContext.class,i);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(JavaParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(JavaParser.AND, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public GuardedPatternContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_guardedPattern; }
	}

	public final GuardedPatternContext guardedPattern() throws RecognitionException {
		return guardedPattern(0);
	}

	private GuardedPatternContext guardedPattern(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		GuardedPatternContext _localctx = new GuardedPatternContext(_ctx, _parentState);
		GuardedPatternContext _prevctx = _localctx;
		int _startState = 204;
		enterRecursionRule(_localctx, 204, RULE_guardedPattern, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1510);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				{
				setState(1485);
				match(LPAREN);
				setState(1486);
				guardedPattern(0);
				setState(1487);
				match(RPAREN);
				}
				break;
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FINAL:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
			case MODULE:
			case OPEN:
			case REQUIRES:
			case EXPORTS:
			case OPENS:
			case TO:
			case USES:
			case PROVIDES:
			case WITH:
			case TRANSITIVE:
			case VAR:
			case YIELD:
			case RECORD:
			case SEALED:
			case PERMITS:
			case AT:
			case IDENTIFIER:
				{
				setState(1492);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,176,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1489);
						variableModifier();
						}
						} 
					}
					setState(1494);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,176,_ctx);
				}
				setState(1495);
				typeType();
				setState(1499);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,177,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1496);
						annotation();
						}
						} 
					}
					setState(1501);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,177,_ctx);
				}
				setState(1502);
				identifier();
				setState(1507);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,178,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1503);
						match(AND);
						setState(1504);
						expression(0);
						}
						} 
					}
					setState(1509);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,178,_ctx);
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(1517);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,180,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new GuardedPatternContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_guardedPattern);
					setState(1512);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(1513);
					match(AND);
					setState(1514);
					expression(0);
					}
					} 
				}
				setState(1519);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,180,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SwitchRuleOutcomeContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<BlockStatementContext> blockStatement() {
			return getRuleContexts(BlockStatementContext.class);
		}
		public BlockStatementContext blockStatement(int i) {
			return getRuleContext(BlockStatementContext.class,i);
		}
		public SwitchRuleOutcomeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_switchRuleOutcome; }
	}

	public final SwitchRuleOutcomeContext switchRuleOutcome() throws RecognitionException {
		SwitchRuleOutcomeContext _localctx = new SwitchRuleOutcomeContext(_ctx, getState());
		enterRule(_localctx, 206, RULE_switchRuleOutcome);
		int _la;
		try {
			setState(1527);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,182,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1520);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1524);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -668508564985026L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 576461783331602427L) != 0) || _la==IDENTIFIER) {
					{
					{
					setState(1521);
					blockStatement();
					}
					}
					setState(1526);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassTypeContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ClassOrInterfaceTypeContext classOrInterfaceType() {
			return getRuleContext(ClassOrInterfaceTypeContext.class,0);
		}
		public TerminalNode DOT() { return getToken(JavaParser.DOT, 0); }
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public ClassTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classType; }
	}

	public final ClassTypeContext classType() throws RecognitionException {
		ClassTypeContext _localctx = new ClassTypeContext(_ctx, getState());
		enterRule(_localctx, 208, RULE_classType);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1532);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,183,_ctx) ) {
			case 1:
				{
				setState(1529);
				classOrInterfaceType();
				setState(1530);
				match(DOT);
				}
				break;
			}
			setState(1537);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,184,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1534);
					annotation();
					}
					} 
				}
				setState(1539);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,184,_ctx);
			}
			setState(1540);
			identifier();
			setState(1542);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(1541);
				typeArguments();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CreatorContext extends ParserRuleContext {
		public CreatedNameContext createdName() {
			return getRuleContext(CreatedNameContext.class,0);
		}
		public ClassCreatorRestContext classCreatorRest() {
			return getRuleContext(ClassCreatorRestContext.class,0);
		}
		public NonWildcardTypeArgumentsContext nonWildcardTypeArguments() {
			return getRuleContext(NonWildcardTypeArgumentsContext.class,0);
		}
		public ArrayCreatorRestContext arrayCreatorRest() {
			return getRuleContext(ArrayCreatorRestContext.class,0);
		}
		public CreatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_creator; }
	}

	public final CreatorContext creator() throws RecognitionException {
		CreatorContext _localctx = new CreatorContext(_ctx, getState());
		enterRule(_localctx, 210, RULE_creator);
		int _la;
		try {
			setState(1553);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,187,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1545);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(1544);
					nonWildcardTypeArguments();
					}
				}

				setState(1547);
				createdName();
				setState(1548);
				classCreatorRest();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1550);
				createdName();
				setState(1551);
				arrayCreatorRest();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CreatedNameContext extends ParserRuleContext {
		public List<IdentifierContext> identifier() {
			return getRuleContexts(IdentifierContext.class);
		}
		public IdentifierContext identifier(int i) {
			return getRuleContext(IdentifierContext.class,i);
		}
		public List<TypeArgumentsOrDiamondContext> typeArgumentsOrDiamond() {
			return getRuleContexts(TypeArgumentsOrDiamondContext.class);
		}
		public TypeArgumentsOrDiamondContext typeArgumentsOrDiamond(int i) {
			return getRuleContext(TypeArgumentsOrDiamondContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(JavaParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(JavaParser.DOT, i);
		}
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public CreatedNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_createdName; }
	}

	public final CreatedNameContext createdName() throws RecognitionException {
		CreatedNameContext _localctx = new CreatedNameContext(_ctx, getState());
		enterRule(_localctx, 212, RULE_createdName);
		int _la;
		try {
			setState(1570);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MODULE:
			case OPEN:
			case REQUIRES:
			case EXPORTS:
			case OPENS:
			case TO:
			case USES:
			case PROVIDES:
			case WITH:
			case TRANSITIVE:
			case VAR:
			case YIELD:
			case RECORD:
			case SEALED:
			case PERMITS:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 1);
				{
				setState(1555);
				identifier();
				setState(1557);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(1556);
					typeArgumentsOrDiamond();
					}
				}

				setState(1566);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==DOT) {
					{
					{
					setState(1559);
					match(DOT);
					setState(1560);
					identifier();
					setState(1562);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==LT) {
						{
						setState(1561);
						typeArgumentsOrDiamond();
						}
					}

					}
					}
					setState(1568);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1569);
				primitiveType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InnerCreatorContext extends ParserRuleContext {
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ClassCreatorRestContext classCreatorRest() {
			return getRuleContext(ClassCreatorRestContext.class,0);
		}
		public NonWildcardTypeArgumentsOrDiamondContext nonWildcardTypeArgumentsOrDiamond() {
			return getRuleContext(NonWildcardTypeArgumentsOrDiamondContext.class,0);
		}
		public InnerCreatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_innerCreator; }
	}

	public final InnerCreatorContext innerCreator() throws RecognitionException {
		InnerCreatorContext _localctx = new InnerCreatorContext(_ctx, getState());
		enterRule(_localctx, 214, RULE_innerCreator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1572);
			identifier();
			setState(1574);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LT) {
				{
				setState(1573);
				nonWildcardTypeArgumentsOrDiamond();
				}
			}

			setState(1576);
			classCreatorRest();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArrayCreatorRestContext extends ParserRuleContext {
		public ArrayInitializerContext arrayInitializer() {
			return getRuleContext(ArrayInitializerContext.class,0);
		}
		public List<TerminalNode> LBRACK() { return getTokens(JavaParser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(JavaParser.LBRACK, i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(JavaParser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(JavaParser.RBRACK, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArrayCreatorRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayCreatorRest; }
	}

	public final ArrayCreatorRestContext arrayCreatorRest() throws RecognitionException {
		ArrayCreatorRestContext _localctx = new ArrayCreatorRestContext(_ctx, getState());
		enterRule(_localctx, 216, RULE_arrayCreatorRest);
		int _la;
		try {
			int _alt;
			setState(1600);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,196,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1580); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(1578);
					match(LBRACK);
					setState(1579);
					match(RBRACK);
					}
					}
					setState(1582); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==LBRACK );
				setState(1584);
				arrayInitializer();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1589); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(1585);
						match(LBRACK);
						setState(1586);
						expression(0);
						setState(1587);
						match(RBRACK);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(1591); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,194,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(1597);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,195,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1593);
						match(LBRACK);
						setState(1594);
						match(RBRACK);
						}
						} 
					}
					setState(1599);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,195,_ctx);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassCreatorRestContext extends ParserRuleContext {
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public ClassCreatorRestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classCreatorRest; }
	}

	public final ClassCreatorRestContext classCreatorRest() throws RecognitionException {
		ClassCreatorRestContext _localctx = new ClassCreatorRestContext(_ctx, getState());
		enterRule(_localctx, 218, RULE_classCreatorRest);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1602);
			arguments();
			setState(1604);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,197,_ctx) ) {
			case 1:
				{
				setState(1603);
				classBody();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExplicitGenericInvocationContext extends ParserRuleContext {
		public NonWildcardTypeArgumentsContext nonWildcardTypeArguments() {
			return getRuleContext(NonWildcardTypeArgumentsContext.class,0);
		}
		public ExplicitGenericInvocationSuffixContext explicitGenericInvocationSuffix() {
			return getRuleContext(ExplicitGenericInvocationSuffixContext.class,0);
		}
		public ExplicitGenericInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_explicitGenericInvocation; }
	}

	public final ExplicitGenericInvocationContext explicitGenericInvocation() throws RecognitionException {
		ExplicitGenericInvocationContext _localctx = new ExplicitGenericInvocationContext(_ctx, getState());
		enterRule(_localctx, 220, RULE_explicitGenericInvocation);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1606);
			nonWildcardTypeArguments();
			setState(1607);
			explicitGenericInvocationSuffix();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeArgumentsOrDiamondContext extends ParserRuleContext {
		public TerminalNode LT() { return getToken(JavaParser.LT, 0); }
		public TerminalNode GT() { return getToken(JavaParser.GT, 0); }
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public TypeArgumentsOrDiamondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeArgumentsOrDiamond; }
	}

	public final TypeArgumentsOrDiamondContext typeArgumentsOrDiamond() throws RecognitionException {
		TypeArgumentsOrDiamondContext _localctx = new TypeArgumentsOrDiamondContext(_ctx, getState());
		enterRule(_localctx, 222, RULE_typeArgumentsOrDiamond);
		try {
			setState(1612);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,198,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1609);
				match(LT);
				setState(1610);
				match(GT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1611);
				typeArguments();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NonWildcardTypeArgumentsOrDiamondContext extends ParserRuleContext {
		public TerminalNode LT() { return getToken(JavaParser.LT, 0); }
		public TerminalNode GT() { return getToken(JavaParser.GT, 0); }
		public NonWildcardTypeArgumentsContext nonWildcardTypeArguments() {
			return getRuleContext(NonWildcardTypeArgumentsContext.class,0);
		}
		public NonWildcardTypeArgumentsOrDiamondContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonWildcardTypeArgumentsOrDiamond; }
	}

	public final NonWildcardTypeArgumentsOrDiamondContext nonWildcardTypeArgumentsOrDiamond() throws RecognitionException {
		NonWildcardTypeArgumentsOrDiamondContext _localctx = new NonWildcardTypeArgumentsOrDiamondContext(_ctx, getState());
		enterRule(_localctx, 224, RULE_nonWildcardTypeArgumentsOrDiamond);
		try {
			setState(1617);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,199,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1614);
				match(LT);
				setState(1615);
				match(GT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1616);
				nonWildcardTypeArguments();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NonWildcardTypeArgumentsContext extends ParserRuleContext {
		public TerminalNode LT() { return getToken(JavaParser.LT, 0); }
		public TypeListContext typeList() {
			return getRuleContext(TypeListContext.class,0);
		}
		public TerminalNode GT() { return getToken(JavaParser.GT, 0); }
		public NonWildcardTypeArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nonWildcardTypeArguments; }
	}

	public final NonWildcardTypeArgumentsContext nonWildcardTypeArguments() throws RecognitionException {
		NonWildcardTypeArgumentsContext _localctx = new NonWildcardTypeArgumentsContext(_ctx, getState());
		enterRule(_localctx, 226, RULE_nonWildcardTypeArguments);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1619);
			match(LT);
			setState(1620);
			typeList();
			setState(1621);
			match(GT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeListContext extends ParserRuleContext {
		public List<TypeTypeContext> typeType() {
			return getRuleContexts(TypeTypeContext.class);
		}
		public TypeTypeContext typeType(int i) {
			return getRuleContext(TypeTypeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(JavaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JavaParser.COMMA, i);
		}
		public TypeListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeList; }
	}

	public final TypeListContext typeList() throws RecognitionException {
		TypeListContext _localctx = new TypeListContext(_ctx, getState());
		enterRule(_localctx, 228, RULE_typeList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1623);
			typeType();
			setState(1628);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1624);
				match(COMMA);
				setState(1625);
				typeType();
				}
				}
				setState(1630);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeTypeContext extends ParserRuleContext {
		public ClassOrInterfaceTypeContext classOrInterfaceType() {
			return getRuleContext(ClassOrInterfaceTypeContext.class,0);
		}
		public PrimitiveTypeContext primitiveType() {
			return getRuleContext(PrimitiveTypeContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public List<TerminalNode> LBRACK() { return getTokens(JavaParser.LBRACK); }
		public TerminalNode LBRACK(int i) {
			return getToken(JavaParser.LBRACK, i);
		}
		public List<TerminalNode> RBRACK() { return getTokens(JavaParser.RBRACK); }
		public TerminalNode RBRACK(int i) {
			return getToken(JavaParser.RBRACK, i);
		}
		public TypeTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeType; }
	}

	public final TypeTypeContext typeType() throws RecognitionException {
		TypeTypeContext _localctx = new TypeTypeContext(_ctx, getState());
		enterRule(_localctx, 230, RULE_typeType);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1634);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,201,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1631);
					annotation();
					}
					} 
				}
				setState(1636);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,201,_ctx);
			}
			setState(1639);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MODULE:
			case OPEN:
			case REQUIRES:
			case EXPORTS:
			case OPENS:
			case TO:
			case USES:
			case PROVIDES:
			case WITH:
			case TRANSITIVE:
			case VAR:
			case YIELD:
			case RECORD:
			case SEALED:
			case PERMITS:
			case IDENTIFIER:
				{
				setState(1637);
				classOrInterfaceType();
				}
				break;
			case BOOLEAN:
			case BYTE:
			case CHAR:
			case DOUBLE:
			case FLOAT:
			case INT:
			case LONG:
			case SHORT:
				{
				setState(1638);
				primitiveType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1651);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,204,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1644);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (((((_la - 51)) & ~0x3f) == 0 && ((1L << (_la - 51)) & 32767L) != 0) || _la==AT || _la==IDENTIFIER) {
						{
						{
						setState(1641);
						annotation();
						}
						}
						setState(1646);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1647);
					match(LBRACK);
					setState(1648);
					match(RBRACK);
					}
					} 
				}
				setState(1653);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,204,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrimitiveTypeContext extends ParserRuleContext {
		public TerminalNode BOOLEAN() { return getToken(JavaParser.BOOLEAN, 0); }
		public TerminalNode CHAR() { return getToken(JavaParser.CHAR, 0); }
		public TerminalNode BYTE() { return getToken(JavaParser.BYTE, 0); }
		public TerminalNode SHORT() { return getToken(JavaParser.SHORT, 0); }
		public TerminalNode INT() { return getToken(JavaParser.INT, 0); }
		public TerminalNode LONG() { return getToken(JavaParser.LONG, 0); }
		public TerminalNode FLOAT() { return getToken(JavaParser.FLOAT, 0); }
		public TerminalNode DOUBLE() { return getToken(JavaParser.DOUBLE, 0); }
		public PrimitiveTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitiveType; }
	}

	public final PrimitiveTypeContext primitiveType() throws RecognitionException {
		PrimitiveTypeContext _localctx = new PrimitiveTypeContext(_ctx, getState());
		enterRule(_localctx, 232, RULE_primitiveType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1654);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 138111107368L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeArgumentsContext extends ParserRuleContext {
		public TerminalNode LT() { return getToken(JavaParser.LT, 0); }
		public List<TypeArgumentContext> typeArgument() {
			return getRuleContexts(TypeArgumentContext.class);
		}
		public TypeArgumentContext typeArgument(int i) {
			return getRuleContext(TypeArgumentContext.class,i);
		}
		public TerminalNode GT() { return getToken(JavaParser.GT, 0); }
		public List<TerminalNode> COMMA() { return getTokens(JavaParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(JavaParser.COMMA, i);
		}
		public TypeArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeArguments; }
	}

	public final TypeArgumentsContext typeArguments() throws RecognitionException {
		TypeArgumentsContext _localctx = new TypeArgumentsContext(_ctx, getState());
		enterRule(_localctx, 234, RULE_typeArguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1656);
			match(LT);
			setState(1657);
			typeArgument();
			setState(1662);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(1658);
				match(COMMA);
				setState(1659);
				typeArgument();
				}
				}
				setState(1664);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1665);
			match(GT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SuperSuffixContext extends ParserRuleContext {
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public TerminalNode DOT() { return getToken(JavaParser.DOT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public SuperSuffixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_superSuffix; }
	}

	public final SuperSuffixContext superSuffix() throws RecognitionException {
		SuperSuffixContext _localctx = new SuperSuffixContext(_ctx, getState());
		enterRule(_localctx, 236, RULE_superSuffix);
		int _la;
		try {
			setState(1676);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
				enterOuterAlt(_localctx, 1);
				{
				setState(1667);
				arguments();
				}
				break;
			case DOT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1668);
				match(DOT);
				setState(1670);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LT) {
					{
					setState(1669);
					typeArguments();
					}
				}

				setState(1672);
				identifier();
				setState(1674);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,207,_ctx) ) {
				case 1:
					{
					setState(1673);
					arguments();
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExplicitGenericInvocationSuffixContext extends ParserRuleContext {
		public TerminalNode SUPER() { return getToken(JavaParser.SUPER, 0); }
		public SuperSuffixContext superSuffix() {
			return getRuleContext(SuperSuffixContext.class,0);
		}
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public ExplicitGenericInvocationSuffixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_explicitGenericInvocationSuffix; }
	}

	public final ExplicitGenericInvocationSuffixContext explicitGenericInvocationSuffix() throws RecognitionException {
		ExplicitGenericInvocationSuffixContext _localctx = new ExplicitGenericInvocationSuffixContext(_ctx, getState());
		enterRule(_localctx, 238, RULE_explicitGenericInvocationSuffix);
		try {
			setState(1683);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case SUPER:
				enterOuterAlt(_localctx, 1);
				{
				setState(1678);
				match(SUPER);
				setState(1679);
				superSuffix();
				}
				break;
			case MODULE:
			case OPEN:
			case REQUIRES:
			case EXPORTS:
			case OPENS:
			case TO:
			case USES:
			case PROVIDES:
			case WITH:
			case TRANSITIVE:
			case VAR:
			case YIELD:
			case RECORD:
			case SEALED:
			case PERMITS:
			case IDENTIFIER:
				enterOuterAlt(_localctx, 2);
				{
				setState(1680);
				identifier();
				setState(1681);
				arguments();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ArgumentsContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(JavaParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(JavaParser.RPAREN, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 240, RULE_arguments);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1685);
			match(LPAREN);
			setState(1687);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 3)) & ~0x3f) == 0 && ((1L << (_la - 3)) & 9223127275610966053L) != 0) || ((((_la - 67)) & ~0x3f) == 0 && ((1L << (_la - 67)) & -9151314313938464769L) != 0)) {
				{
				setState(1686);
				expressionList();
				}
			}

			setState(1689);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 94:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		case 102:
			return guardedPattern_sempred((GuardedPatternContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 14);
		case 1:
			return precpred(_ctx, 13);
		case 2:
			return precpred(_ctx, 12);
		case 3:
			return precpred(_ctx, 11);
		case 4:
			return precpred(_ctx, 9);
		case 5:
			return precpred(_ctx, 8);
		case 6:
			return precpred(_ctx, 7);
		case 7:
			return precpred(_ctx, 6);
		case 8:
			return precpred(_ctx, 5);
		case 9:
			return precpred(_ctx, 4);
		case 10:
			return precpred(_ctx, 3);
		case 11:
			return precpred(_ctx, 2);
		case 12:
			return precpred(_ctx, 25);
		case 13:
			return precpred(_ctx, 24);
		case 14:
			return precpred(_ctx, 22);
		case 15:
			return precpred(_ctx, 18);
		case 16:
			return precpred(_ctx, 10);
		}
		return true;
	}
	private boolean guardedPattern_sempred(GuardedPatternContext _localctx, int predIndex) {
		switch (predIndex) {
		case 17:
			return precpred(_ctx, 1);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0082\u069c\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007"+
		"\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007"+
		"\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007"+
		"\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007"+
		"\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007"+
		"\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007"+
		",\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u0007"+
		"1\u00022\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u0007"+
		"6\u00027\u00077\u00028\u00078\u00029\u00079\u0002:\u0007:\u0002;\u0007"+
		";\u0002<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007?\u0002@\u0007"+
		"@\u0002A\u0007A\u0002B\u0007B\u0002C\u0007C\u0002D\u0007D\u0002E\u0007"+
		"E\u0002F\u0007F\u0002G\u0007G\u0002H\u0007H\u0002I\u0007I\u0002J\u0007"+
		"J\u0002K\u0007K\u0002L\u0007L\u0002M\u0007M\u0002N\u0007N\u0002O\u0007"+
		"O\u0002P\u0007P\u0002Q\u0007Q\u0002R\u0007R\u0002S\u0007S\u0002T\u0007"+
		"T\u0002U\u0007U\u0002V\u0007V\u0002W\u0007W\u0002X\u0007X\u0002Y\u0007"+
		"Y\u0002Z\u0007Z\u0002[\u0007[\u0002\\\u0007\\\u0002]\u0007]\u0002^\u0007"+
		"^\u0002_\u0007_\u0002`\u0007`\u0002a\u0007a\u0002b\u0007b\u0002c\u0007"+
		"c\u0002d\u0007d\u0002e\u0007e\u0002f\u0007f\u0002g\u0007g\u0002h\u0007"+
		"h\u0002i\u0007i\u0002j\u0007j\u0002k\u0007k\u0002l\u0007l\u0002m\u0007"+
		"m\u0002n\u0007n\u0002o\u0007o\u0002p\u0007p\u0002q\u0007q\u0002r\u0007"+
		"r\u0002s\u0007s\u0002t\u0007t\u0002u\u0007u\u0002v\u0007v\u0002w\u0007"+
		"w\u0002x\u0007x\u0001\u0000\u0003\u0000\u00f4\b\u0000\u0001\u0000\u0001"+
		"\u0000\u0005\u0000\u00f8\b\u0000\n\u0000\f\u0000\u00fb\t\u0000\u0001\u0000"+
		"\u0001\u0000\u0005\u0000\u00ff\b\u0000\n\u0000\f\u0000\u0102\t\u0000\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0003\u0000\u0107\b\u0000\u0001\u0001\u0005"+
		"\u0001\u010a\b\u0001\n\u0001\f\u0001\u010d\t\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0001\u0001\u0002\u0001\u0002\u0003\u0002\u0115\b\u0002"+
		"\u0001\u0002\u0001\u0002\u0001\u0002\u0003\u0002\u011a\b\u0002\u0001\u0002"+
		"\u0001\u0002\u0001\u0003\u0005\u0003\u011f\b\u0003\n\u0003\f\u0003\u0122"+
		"\t\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u0128"+
		"\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003"+
		"\u0004\u012f\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0001"+
		"\u0005\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u0139\b\u0005\u0001"+
		"\u0006\u0001\u0006\u0003\u0006\u013d\b\u0006\u0001\u0007\u0001\u0007\u0001"+
		"\u0007\u0003\u0007\u0142\b\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u0146"+
		"\b\u0007\u0001\u0007\u0001\u0007\u0003\u0007\u014a\b\u0007\u0001\u0007"+
		"\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0005\b\u0152\b\b\n\b\f\b"+
		"\u0155\t\b\u0001\b\u0001\b\u0001\t\u0005\t\u015a\b\t\n\t\f\t\u015d\t\t"+
		"\u0001\t\u0001\t\u0001\t\u0005\t\u0162\b\t\n\t\f\t\u0165\t\t\u0001\t\u0003"+
		"\t\u0168\b\t\u0001\n\u0001\n\u0001\n\u0005\n\u016d\b\n\n\n\f\n\u0170\t"+
		"\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u0176\b"+
		"\u000b\u0001\u000b\u0001\u000b\u0003\u000b\u017a\b\u000b\u0001\u000b\u0003"+
		"\u000b\u017d\b\u000b\u0001\u000b\u0003\u000b\u0180\b\u000b\u0001\u000b"+
		"\u0001\u000b\u0001\f\u0001\f\u0001\f\u0005\f\u0187\b\f\n\f\f\f\u018a\t"+
		"\f\u0001\r\u0005\r\u018d\b\r\n\r\f\r\u0190\t\r\u0001\r\u0001\r\u0003\r"+
		"\u0194\b\r\u0001\r\u0003\r\u0197\b\r\u0001\u000e\u0001\u000e\u0005\u000e"+
		"\u019b\b\u000e\n\u000e\f\u000e\u019e\t\u000e\u0001\u000f\u0001\u000f\u0001"+
		"\u000f\u0003\u000f\u01a3\b\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u01a7"+
		"\b\u000f\u0001\u000f\u0001\u000f\u0003\u000f\u01ab\b\u000f\u0001\u000f"+
		"\u0001\u000f\u0001\u0010\u0001\u0010\u0005\u0010\u01b1\b\u0010\n\u0010"+
		"\f\u0010\u01b4\t\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011"+
		"\u0005\u0011\u01ba\b\u0011\n\u0011\f\u0011\u01bd\t\u0011\u0001\u0011\u0001"+
		"\u0011\u0001\u0012\u0001\u0012\u0003\u0012\u01c3\b\u0012\u0001\u0012\u0001"+
		"\u0012\u0005\u0012\u01c7\b\u0012\n\u0012\f\u0012\u01ca\t\u0012\u0001\u0012"+
		"\u0003\u0012\u01cd\b\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013"+
		"\u01d8\b\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014\u0001\u0014"+
		"\u0005\u0014\u01df\b\u0014\n\u0014\f\u0014\u01e2\t\u0014\u0001\u0014\u0001"+
		"\u0014\u0003\u0014\u01e6\b\u0014\u0001\u0014\u0001\u0014\u0001\u0015\u0001"+
		"\u0015\u0003\u0015\u01ec\b\u0015\u0001\u0016\u0001\u0016\u0003\u0016\u01f0"+
		"\b\u0016\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0001\u0018\u0001"+
		"\u0018\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u01fc"+
		"\b\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0005\u001a\u0201\b\u001a"+
		"\n\u001a\f\u001a\u0204\t\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0001"+
		"\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001c\u0005\u001c\u020e"+
		"\b\u001c\n\u001c\f\u001c\u0211\t\u001c\u0001\u001c\u0001\u001c\u0003\u001c"+
		"\u0215\b\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d\u0001\u001d"+
		"\u0001\u001d\u0001\u001d\u0003\u001d\u021e\b\u001d\u0001\u001e\u0001\u001e"+
		"\u0001\u001e\u0001\u001e\u0005\u001e\u0224\b\u001e\n\u001e\f\u001e\u0227"+
		"\t\u001e\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001\u001f\u0005"+
		"\u001f\u022e\b\u001f\n\u001f\f\u001f\u0231\t\u001f\u0001\u001f\u0001\u001f"+
		"\u0001\u001f\u0001 \u0005 \u0237\b \n \f \u023a\t \u0001 \u0001 \u0001"+
		"!\u0001!\u0001!\u0001!\u0001!\u0001!\u0003!\u0244\b!\u0001\"\u0005\"\u0247"+
		"\b\"\n\"\f\"\u024a\t\"\u0001\"\u0001\"\u0001\"\u0001#\u0005#\u0250\b#"+
		"\n#\f#\u0253\t#\u0001#\u0001#\u0001#\u0001#\u0001#\u0005#\u025a\b#\n#"+
		"\f#\u025d\t#\u0001#\u0001#\u0003#\u0261\b#\u0001#\u0001#\u0001$\u0001"+
		"$\u0001$\u0005$\u0268\b$\n$\f$\u026b\t$\u0001%\u0001%\u0001%\u0003%\u0270"+
		"\b%\u0001&\u0001&\u0001&\u0005&\u0275\b&\n&\f&\u0278\t&\u0001\'\u0001"+
		"\'\u0003\'\u027c\b\'\u0001(\u0001(\u0001(\u0001(\u0005(\u0282\b(\n(\f"+
		"(\u0285\t(\u0001(\u0003(\u0288\b(\u0003(\u028a\b(\u0001(\u0001(\u0001"+
		")\u0001)\u0003)\u0290\b)\u0001)\u0001)\u0005)\u0294\b)\n)\f)\u0297\t)"+
		"\u0001)\u0001)\u0003)\u029b\b)\u0001*\u0001*\u0005*\u029f\b*\n*\f*\u02a2"+
		"\t*\u0001*\u0001*\u0001*\u0003*\u02a7\b*\u0003*\u02a9\b*\u0001+\u0001"+
		"+\u0001+\u0005+\u02ae\b+\n+\f+\u02b1\t+\u0001,\u0001,\u0003,\u02b5\b,"+
		"\u0001,\u0001,\u0001,\u0003,\u02ba\b,\u0001,\u0003,\u02bd\b,\u0003,\u02bf"+
		"\b,\u0001,\u0001,\u0001-\u0001-\u0001-\u0001-\u0005-\u02c7\b-\n-\f-\u02ca"+
		"\t-\u0001-\u0001-\u0001.\u0001.\u0001.\u0005.\u02d1\b.\n.\f.\u02d4\t."+
		"\u0001.\u0001.\u0003.\u02d8\b.\u0001.\u0003.\u02db\b.\u0001/\u0005/\u02de"+
		"\b/\n/\f/\u02e1\t/\u0001/\u0001/\u0001/\u00010\u00050\u02e7\b0\n0\f0\u02ea"+
		"\t0\u00010\u00010\u00050\u02ee\b0\n0\f0\u02f1\t0\u00010\u00010\u00010"+
		"\u00011\u00011\u00011\u00051\u02f9\b1\n1\f1\u02fc\t1\u00012\u00052\u02ff"+
		"\b2\n2\f2\u0302\t2\u00012\u00012\u00012\u00013\u00013\u00013\u00053\u030a"+
		"\b3\n3\f3\u030d\t3\u00014\u00014\u00014\u00014\u00014\u00014\u00014\u0003"+
		"4\u0316\b4\u00015\u00015\u00016\u00016\u00017\u00017\u00017\u00057\u031f"+
		"\b7\n7\f7\u0322\t7\u00017\u00017\u00017\u00018\u00018\u00018\u00038\u032a"+
		"\b8\u00018\u00018\u00018\u00038\u032f\b8\u00018\u00038\u0332\b8\u0001"+
		"9\u00019\u00019\u00059\u0337\b9\n9\f9\u033a\t9\u0001:\u0001:\u0001:\u0001"+
		":\u0001;\u0001;\u0001;\u0003;\u0343\b;\u0001<\u0001<\u0001<\u0001<\u0005"+
		"<\u0349\b<\n<\f<\u034c\t<\u0003<\u034e\b<\u0001<\u0003<\u0351\b<\u0001"+
		"<\u0001<\u0001=\u0001=\u0001=\u0001=\u0001=\u0001>\u0001>\u0005>\u035c"+
		"\b>\n>\f>\u035f\t>\u0001>\u0001>\u0001?\u0005?\u0364\b?\n?\f?\u0367\t"+
		"?\u0001?\u0001?\u0003?\u036b\b?\u0001@\u0001@\u0001@\u0001@\u0001@\u0001"+
		"@\u0003@\u0373\b@\u0001@\u0001@\u0003@\u0377\b@\u0001@\u0001@\u0003@\u037b"+
		"\b@\u0001@\u0001@\u0003@\u037f\b@\u0003@\u0381\b@\u0001A\u0001A\u0003"+
		"A\u0385\bA\u0001B\u0001B\u0001B\u0001B\u0003B\u038b\bB\u0001C\u0001C\u0001"+
		"D\u0001D\u0001D\u0001E\u0003E\u0393\bE\u0001E\u0001E\u0001E\u0001E\u0001"+
		"F\u0001F\u0005F\u039b\bF\nF\fF\u039e\tF\u0001F\u0001F\u0001G\u0001G\u0005"+
		"G\u03a4\bG\nG\fG\u03a7\tG\u0001G\u0001G\u0001G\u0001G\u0001G\u0001G\u0001"+
		"G\u0003G\u03b0\bG\u0001G\u0001G\u0001G\u0001G\u0001G\u0001G\u0003G\u03b8"+
		"\bG\u0001G\u0001G\u0001G\u0001G\u0001G\u0001G\u0001G\u0001G\u0001G\u0001"+
		"G\u0001G\u0001G\u0003G\u03c6\bG\u0001H\u0001H\u0001I\u0001I\u0005I\u03cc"+
		"\bI\nI\fI\u03cf\tI\u0001I\u0001I\u0001J\u0001J\u0001J\u0001J\u0001J\u0003"+
		"J\u03d8\bJ\u0001K\u0005K\u03db\bK\nK\fK\u03de\tK\u0001K\u0001K\u0001K"+
		"\u0001K\u0001K\u0001K\u0001K\u0001K\u0003K\u03e8\bK\u0001L\u0001L\u0001"+
		"M\u0001M\u0001N\u0005N\u03ef\bN\nN\fN\u03f2\tN\u0001N\u0001N\u0003N\u03f6"+
		"\bN\u0001O\u0001O\u0001O\u0001O\u0001O\u0003O\u03fd\bO\u0001O\u0001O\u0001"+
		"O\u0001O\u0001O\u0001O\u0001O\u0003O\u0406\bO\u0001O\u0001O\u0001O\u0001"+
		"O\u0001O\u0001O\u0001O\u0001O\u0001O\u0001O\u0001O\u0001O\u0001O\u0001"+
		"O\u0001O\u0001O\u0001O\u0001O\u0001O\u0004O\u041b\bO\u000bO\fO\u041c\u0001"+
		"O\u0003O\u0420\bO\u0001O\u0003O\u0423\bO\u0001O\u0001O\u0001O\u0001O\u0005"+
		"O\u0429\bO\nO\fO\u042c\tO\u0001O\u0003O\u042f\bO\u0001O\u0001O\u0001O"+
		"\u0001O\u0005O\u0435\bO\nO\fO\u0438\tO\u0001O\u0005O\u043b\bO\nO\fO\u043e"+
		"\tO\u0001O\u0001O\u0001O\u0001O\u0001O\u0001O\u0001O\u0001O\u0003O\u0448"+
		"\bO\u0001O\u0001O\u0001O\u0001O\u0001O\u0001O\u0001O\u0003O\u0451\bO\u0001"+
		"O\u0001O\u0001O\u0003O\u0456\bO\u0001O\u0001O\u0001O\u0001O\u0001O\u0001"+
		"O\u0001O\u0001O\u0001O\u0001O\u0001O\u0003O\u0463\bO\u0001O\u0001O\u0001"+
		"O\u0001O\u0003O\u0469\bO\u0001P\u0001P\u0001P\u0005P\u046e\bP\nP\fP\u0471"+
		"\tP\u0001P\u0001P\u0001P\u0001P\u0001P\u0001Q\u0001Q\u0001Q\u0005Q\u047b"+
		"\bQ\nQ\fQ\u047e\tQ\u0001R\u0001R\u0001R\u0001S\u0001S\u0001S\u0003S\u0486"+
		"\bS\u0001S\u0001S\u0001T\u0001T\u0001T\u0005T\u048d\bT\nT\fT\u0490\tT"+
		"\u0001U\u0005U\u0493\bU\nU\fU\u0496\tU\u0001U\u0001U\u0001U\u0001U\u0001"+
		"U\u0003U\u049d\bU\u0001U\u0001U\u0001U\u0001U\u0003U\u04a3\bU\u0001V\u0004"+
		"V\u04a6\bV\u000bV\fV\u04a7\u0001V\u0004V\u04ab\bV\u000bV\fV\u04ac\u0001"+
		"W\u0001W\u0001W\u0001W\u0001W\u0001W\u0003W\u04b5\bW\u0001W\u0001W\u0001"+
		"W\u0003W\u04ba\bW\u0001X\u0001X\u0003X\u04be\bX\u0001X\u0001X\u0003X\u04c2"+
		"\bX\u0001X\u0001X\u0003X\u04c6\bX\u0003X\u04c8\bX\u0001Y\u0001Y\u0003"+
		"Y\u04cc\bY\u0001Z\u0005Z\u04cf\bZ\nZ\fZ\u04d2\tZ\u0001Z\u0001Z\u0003Z"+
		"\u04d6\bZ\u0001Z\u0001Z\u0001Z\u0001Z\u0001[\u0001[\u0001[\u0001[\u0001"+
		"\\\u0001\\\u0001\\\u0005\\\u04e3\b\\\n\\\f\\\u04e6\t\\\u0001]\u0001]\u0001"+
		"]\u0003]\u04eb\b]\u0001]\u0001]\u0001^\u0001^\u0001^\u0001^\u0001^\u0001"+
		"^\u0003^\u04f5\b^\u0001^\u0001^\u0003^\u04f9\b^\u0001^\u0001^\u0001^\u0003"+
		"^\u04fe\b^\u0001^\u0001^\u0001^\u0001^\u0001^\u0001^\u0001^\u0005^\u0507"+
		"\b^\n^\f^\u050a\t^\u0001^\u0001^\u0001^\u0005^\u050f\b^\n^\f^\u0512\t"+
		"^\u0001^\u0001^\u0001^\u0001^\u0001^\u0001^\u0003^\u051a\b^\u0001^\u0001"+
		"^\u0001^\u0001^\u0001^\u0001^\u0001^\u0001^\u0001^\u0001^\u0001^\u0001"+
		"^\u0001^\u0001^\u0003^\u052a\b^\u0001^\u0001^\u0001^\u0001^\u0001^\u0001"+
		"^\u0001^\u0001^\u0001^\u0001^\u0001^\u0001^\u0001^\u0001^\u0001^\u0001"+
		"^\u0001^\u0001^\u0001^\u0001^\u0001^\u0001^\u0001^\u0001^\u0001^\u0001"+
		"^\u0001^\u0001^\u0001^\u0001^\u0001^\u0001^\u0001^\u0001^\u0001^\u0001"+
		"^\u0001^\u0001^\u0001^\u0001^\u0001^\u0001^\u0001^\u0003^\u0557\b^\u0001"+
		"^\u0001^\u0001^\u0001^\u0003^\u055d\b^\u0001^\u0001^\u0001^\u0003^\u0562"+
		"\b^\u0001^\u0001^\u0001^\u0001^\u0001^\u0001^\u0001^\u0003^\u056b\b^\u0005"+
		"^\u056d\b^\n^\f^\u0570\t^\u0001_\u0005_\u0573\b_\n_\f_\u0576\t_\u0001"+
		"_\u0001_\u0005_\u057a\b_\n_\f_\u057d\t_\u0001_\u0001_\u0001`\u0001`\u0001"+
		"`\u0001`\u0001a\u0001a\u0001a\u0003a\u0588\ba\u0001a\u0001a\u0001a\u0001"+
		"a\u0001a\u0005a\u058f\ba\na\fa\u0592\ta\u0001a\u0001a\u0001a\u0001a\u0003"+
		"a\u0598\ba\u0001a\u0003a\u059b\ba\u0001b\u0001b\u0003b\u059f\bb\u0001"+
		"c\u0001c\u0001c\u0001c\u0001c\u0001c\u0001c\u0001c\u0001c\u0001c\u0001"+
		"c\u0001c\u0001c\u0001c\u0001c\u0001c\u0003c\u05b1\bc\u0003c\u05b3\bc\u0001"+
		"d\u0001d\u0001d\u0001d\u0005d\u05b9\bd\nd\fd\u05bc\td\u0001d\u0001d\u0001"+
		"e\u0001e\u0001e\u0001e\u0003e\u05c4\be\u0001e\u0001e\u0001e\u0001e\u0001"+
		"e\u0003e\u05cb\be\u0001f\u0001f\u0001f\u0001f\u0001f\u0001f\u0005f\u05d3"+
		"\bf\nf\ff\u05d6\tf\u0001f\u0001f\u0005f\u05da\bf\nf\ff\u05dd\tf\u0001"+
		"f\u0001f\u0001f\u0005f\u05e2\bf\nf\ff\u05e5\tf\u0003f\u05e7\bf\u0001f"+
		"\u0001f\u0001f\u0005f\u05ec\bf\nf\ff\u05ef\tf\u0001g\u0001g\u0005g\u05f3"+
		"\bg\ng\fg\u05f6\tg\u0003g\u05f8\bg\u0001h\u0001h\u0001h\u0003h\u05fd\b"+
		"h\u0001h\u0005h\u0600\bh\nh\fh\u0603\th\u0001h\u0001h\u0003h\u0607\bh"+
		"\u0001i\u0003i\u060a\bi\u0001i\u0001i\u0001i\u0001i\u0001i\u0001i\u0003"+
		"i\u0612\bi\u0001j\u0001j\u0003j\u0616\bj\u0001j\u0001j\u0001j\u0003j\u061b"+
		"\bj\u0005j\u061d\bj\nj\fj\u0620\tj\u0001j\u0003j\u0623\bj\u0001k\u0001"+
		"k\u0003k\u0627\bk\u0001k\u0001k\u0001l\u0001l\u0004l\u062d\bl\u000bl\f"+
		"l\u062e\u0001l\u0001l\u0001l\u0001l\u0001l\u0004l\u0636\bl\u000bl\fl\u0637"+
		"\u0001l\u0001l\u0005l\u063c\bl\nl\fl\u063f\tl\u0003l\u0641\bl\u0001m\u0001"+
		"m\u0003m\u0645\bm\u0001n\u0001n\u0001n\u0001o\u0001o\u0001o\u0003o\u064d"+
		"\bo\u0001p\u0001p\u0001p\u0003p\u0652\bp\u0001q\u0001q\u0001q\u0001q\u0001"+
		"r\u0001r\u0001r\u0005r\u065b\br\nr\fr\u065e\tr\u0001s\u0005s\u0661\bs"+
		"\ns\fs\u0664\ts\u0001s\u0001s\u0003s\u0668\bs\u0001s\u0005s\u066b\bs\n"+
		"s\fs\u066e\ts\u0001s\u0001s\u0005s\u0672\bs\ns\fs\u0675\ts\u0001t\u0001"+
		"t\u0001u\u0001u\u0001u\u0001u\u0005u\u067d\bu\nu\fu\u0680\tu\u0001u\u0001"+
		"u\u0001v\u0001v\u0001v\u0003v\u0687\bv\u0001v\u0001v\u0003v\u068b\bv\u0003"+
		"v\u068d\bv\u0001w\u0001w\u0001w\u0001w\u0001w\u0003w\u0694\bw\u0001x\u0001"+
		"x\u0003x\u0698\bx\u0001x\u0001x\u0001x\u0000\u0002\u00bc\u00ccy\u0000"+
		"\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c"+
		"\u001e \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084"+
		"\u0086\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c"+
		"\u009e\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2\u00b4"+
		"\u00b6\u00b8\u00ba\u00bc\u00be\u00c0\u00c2\u00c4\u00c6\u00c8\u00ca\u00cc"+
		"\u00ce\u00d0\u00d2\u00d4\u00d6\u00d8\u00da\u00dc\u00de\u00e0\u00e2\u00e4"+
		"\u00e6\u00e8\u00ea\u00ec\u00ee\u00f0\u0000\u000f\u0002\u0000\u0011\u0011"+
		"((\u0001\u0000CF\u0001\u0000GH\u0002\u0000&&<<\u0002\u00003A\u0082\u0082"+
		"\u0003\u00003<?A\u0082\u0082\u0002\u0000Z[dg\u0002\u0000himm\u0001\u0000"+
		"fg\u0002\u0000XY_`\u0002\u0000^^aa\u0002\u0000WWnx\u0001\u0000de\u0002"+
		"\u0000]]yy\b\u0000\u0003\u0003\u0005\u0005\b\b\u000e\u000e\u0014\u0014"+
		"\u001b\u001b\u001d\u001d%%\u0756\u0000\u0106\u0001\u0000\u0000\u0000\u0002"+
		"\u010b\u0001\u0000\u0000\u0000\u0004\u0112\u0001\u0000\u0000\u0000\u0006"+
		"\u0120\u0001\u0000\u0000\u0000\b\u012e\u0001\u0000\u0000\u0000\n\u0138"+
		"\u0001\u0000\u0000\u0000\f\u013c\u0001\u0000\u0000\u0000\u000e\u013e\u0001"+
		"\u0000\u0000\u0000\u0010\u014d\u0001\u0000\u0000\u0000\u0012\u015b\u0001"+
		"\u0000\u0000\u0000\u0014\u0169\u0001\u0000\u0000\u0000\u0016\u0171\u0001"+
		"\u0000\u0000\u0000\u0018\u0183\u0001\u0000\u0000\u0000\u001a\u018e\u0001"+
		"\u0000\u0000\u0000\u001c\u0198\u0001\u0000\u0000\u0000\u001e\u019f\u0001"+
		"\u0000\u0000\u0000 \u01ae\u0001\u0000\u0000\u0000\"\u01b7\u0001\u0000"+
		"\u0000\u0000$\u01cc\u0001\u0000\u0000\u0000&\u01d7\u0001\u0000\u0000\u0000"+
		"(\u01d9\u0001\u0000\u0000\u0000*\u01eb\u0001\u0000\u0000\u0000,\u01ef"+
		"\u0001\u0000\u0000\u0000.\u01f1\u0001\u0000\u0000\u00000\u01f4\u0001\u0000"+
		"\u0000\u00002\u01f7\u0001\u0000\u0000\u00004\u0202\u0001\u0000\u0000\u0000"+
		"6\u0208\u0001\u0000\u0000\u00008\u0214\u0001\u0000\u0000\u0000:\u021d"+
		"\u0001\u0000\u0000\u0000<\u021f\u0001\u0000\u0000\u0000>\u022a\u0001\u0000"+
		"\u0000\u0000@\u0238\u0001\u0000\u0000\u0000B\u0243\u0001\u0000\u0000\u0000"+
		"D\u0248\u0001\u0000\u0000\u0000F\u0251\u0001\u0000\u0000\u0000H\u0264"+
		"\u0001\u0000\u0000\u0000J\u026c\u0001\u0000\u0000\u0000L\u0271\u0001\u0000"+
		"\u0000\u0000N\u027b\u0001\u0000\u0000\u0000P\u027d\u0001\u0000\u0000\u0000"+
		"R\u0295\u0001\u0000\u0000\u0000T\u02a8\u0001\u0000\u0000\u0000V\u02aa"+
		"\u0001\u0000\u0000\u0000X\u02b2\u0001\u0000\u0000\u0000Z\u02c2\u0001\u0000"+
		"\u0000\u0000\\\u02da\u0001\u0000\u0000\u0000^\u02df\u0001\u0000\u0000"+
		"\u0000`\u02e8\u0001\u0000\u0000\u0000b\u02f5\u0001\u0000\u0000\u0000d"+
		"\u0300\u0001\u0000\u0000\u0000f\u0306\u0001\u0000\u0000\u0000h\u0315\u0001"+
		"\u0000\u0000\u0000j\u0317\u0001\u0000\u0000\u0000l\u0319\u0001\u0000\u0000"+
		"\u0000n\u0320\u0001\u0000\u0000\u0000p\u0329\u0001\u0000\u0000\u0000r"+
		"\u0333\u0001\u0000\u0000\u0000t\u033b\u0001\u0000\u0000\u0000v\u0342\u0001"+
		"\u0000\u0000\u0000x\u0344\u0001\u0000\u0000\u0000z\u0354\u0001\u0000\u0000"+
		"\u0000|\u0359\u0001\u0000\u0000\u0000~\u036a\u0001\u0000\u0000\u0000\u0080"+
		"\u0380\u0001\u0000\u0000\u0000\u0082\u0384\u0001\u0000\u0000\u0000\u0084"+
		"\u0386\u0001\u0000\u0000\u0000\u0086\u038c\u0001\u0000\u0000\u0000\u0088"+
		"\u038e\u0001\u0000\u0000\u0000\u008a\u0392\u0001\u0000\u0000\u0000\u008c"+
		"\u0398\u0001\u0000\u0000\u0000\u008e\u03c5\u0001\u0000\u0000\u0000\u0090"+
		"\u03c7\u0001\u0000\u0000\u0000\u0092\u03c9\u0001\u0000\u0000\u0000\u0094"+
		"\u03d7\u0001\u0000\u0000\u0000\u0096\u03dc\u0001\u0000\u0000\u0000\u0098"+
		"\u03e9\u0001\u0000\u0000\u0000\u009a\u03eb\u0001\u0000\u0000\u0000\u009c"+
		"\u03f0\u0001\u0000\u0000\u0000\u009e\u0468\u0001\u0000\u0000\u0000\u00a0"+
		"\u046a\u0001\u0000\u0000\u0000\u00a2\u0477\u0001\u0000\u0000\u0000\u00a4"+
		"\u047f\u0001\u0000\u0000\u0000\u00a6\u0482\u0001\u0000\u0000\u0000\u00a8"+
		"\u0489\u0001\u0000\u0000\u0000\u00aa\u04a2\u0001\u0000\u0000\u0000\u00ac"+
		"\u04a5\u0001\u0000\u0000\u0000\u00ae\u04b9\u0001\u0000\u0000\u0000\u00b0"+
		"\u04c7\u0001\u0000\u0000\u0000\u00b2\u04cb\u0001\u0000\u0000\u0000\u00b4"+
		"\u04d0\u0001\u0000\u0000\u0000\u00b6\u04db\u0001\u0000\u0000\u0000\u00b8"+
		"\u04df\u0001\u0000\u0000\u0000\u00ba\u04ea\u0001\u0000\u0000\u0000\u00bc"+
		"\u0519\u0001\u0000\u0000\u0000\u00be\u0574\u0001\u0000\u0000\u0000\u00c0"+
		"\u0580\u0001\u0000\u0000\u0000\u00c2\u059a\u0001\u0000\u0000\u0000\u00c4"+
		"\u059e\u0001\u0000\u0000\u0000\u00c6\u05b2\u0001\u0000\u0000\u0000\u00c8"+
		"\u05b4\u0001\u0000\u0000\u0000\u00ca\u05ca\u0001\u0000\u0000\u0000\u00cc"+
		"\u05e6\u0001\u0000\u0000\u0000\u00ce\u05f7\u0001\u0000\u0000\u0000\u00d0"+
		"\u05fc\u0001\u0000\u0000\u0000\u00d2\u0611\u0001\u0000\u0000\u0000\u00d4"+
		"\u0622\u0001\u0000\u0000\u0000\u00d6\u0624\u0001\u0000\u0000\u0000\u00d8"+
		"\u0640\u0001\u0000\u0000\u0000\u00da\u0642\u0001\u0000\u0000\u0000\u00dc"+
		"\u0646\u0001\u0000\u0000\u0000\u00de\u064c\u0001\u0000\u0000\u0000\u00e0"+
		"\u0651\u0001\u0000\u0000\u0000\u00e2\u0653\u0001\u0000\u0000\u0000\u00e4"+
		"\u0657\u0001\u0000\u0000\u0000\u00e6\u0662\u0001\u0000\u0000\u0000\u00e8"+
		"\u0676\u0001\u0000\u0000\u0000\u00ea\u0678\u0001\u0000\u0000\u0000\u00ec"+
		"\u068c\u0001\u0000\u0000\u0000\u00ee\u0693\u0001\u0000\u0000\u0000\u00f0"+
		"\u0695\u0001\u0000\u0000\u0000\u00f2\u00f4\u0003\u0002\u0001\u0000\u00f3"+
		"\u00f2\u0001\u0000\u0000\u0000\u00f3\u00f4\u0001\u0000\u0000\u0000\u00f4"+
		"\u00f9\u0001\u0000\u0000\u0000\u00f5\u00f8\u0003\u0004\u0002\u0000\u00f6"+
		"\u00f8\u0005T\u0000\u0000\u00f7\u00f5\u0001\u0000\u0000\u0000\u00f7\u00f6"+
		"\u0001\u0000\u0000\u0000\u00f8\u00fb\u0001\u0000\u0000\u0000\u00f9\u00f7"+
		"\u0001\u0000\u0000\u0000\u00f9\u00fa\u0001\u0000\u0000\u0000\u00fa\u0100"+
		"\u0001\u0000\u0000\u0000\u00fb\u00f9\u0001\u0000\u0000\u0000\u00fc\u00ff"+
		"\u0003\u0006\u0003\u0000\u00fd\u00ff\u0005T\u0000\u0000\u00fe\u00fc\u0001"+
		"\u0000\u0000\u0000\u00fe\u00fd\u0001\u0000\u0000\u0000\u00ff\u0102\u0001"+
		"\u0000\u0000\u0000\u0100\u00fe\u0001\u0000\u0000\u0000\u0100\u0101\u0001"+
		"\u0000\u0000\u0000\u0101\u0107\u0001\u0000\u0000\u0000\u0102\u0100\u0001"+
		"\u0000\u0000\u0000\u0103\u0104\u0003\u008aE\u0000\u0104\u0105\u0005\u0000"+
		"\u0000\u0001\u0105\u0107\u0001\u0000\u0000\u0000\u0106\u00f3\u0001\u0000"+
		"\u0000\u0000\u0106\u0103\u0001\u0000\u0000\u0000\u0107\u0001\u0001\u0000"+
		"\u0000\u0000\u0108\u010a\u0003p8\u0000\u0109\u0108\u0001\u0000\u0000\u0000"+
		"\u010a\u010d\u0001\u0000\u0000\u0000\u010b\u0109\u0001\u0000\u0000\u0000"+
		"\u010b\u010c\u0001\u0000\u0000\u0000\u010c\u010e\u0001\u0000\u0000\u0000"+
		"\u010d\u010b\u0001\u0000\u0000\u0000\u010e\u010f\u0005 \u0000\u0000\u010f"+
		"\u0110\u0003f3\u0000\u0110\u0111\u0005T\u0000\u0000\u0111\u0003\u0001"+
		"\u0000\u0000\u0000\u0112\u0114\u0005\u0019\u0000\u0000\u0113\u0115\u0005"+
		"&\u0000\u0000\u0114\u0113\u0001\u0000\u0000\u0000\u0114\u0115\u0001\u0000"+
		"\u0000\u0000\u0115\u0116\u0001\u0000\u0000\u0000\u0116\u0119\u0003f3\u0000"+
		"\u0117\u0118\u0005V\u0000\u0000\u0118\u011a\u0005h\u0000\u0000\u0119\u0117"+
		"\u0001\u0000\u0000\u0000\u0119\u011a\u0001\u0000\u0000\u0000\u011a\u011b"+
		"\u0001\u0000\u0000\u0000\u011b\u011c\u0005T\u0000\u0000\u011c\u0005\u0001"+
		"\u0000\u0000\u0000\u011d\u011f\u0003\n\u0005\u0000\u011e\u011d\u0001\u0000"+
		"\u0000\u0000\u011f\u0122\u0001\u0000\u0000\u0000\u0120\u011e\u0001\u0000"+
		"\u0000\u0000\u0120\u0121\u0001\u0000\u0000\u0000\u0121\u0127\u0001\u0000"+
		"\u0000\u0000\u0122\u0120\u0001\u0000\u0000\u0000\u0123\u0128\u0003\u000e"+
		"\u0007\u0000\u0124\u0128\u0003\u0016\u000b\u0000\u0125\u0128\u0003\u001e"+
		"\u000f\u0000\u0126\u0128\u0003z=\u0000\u0127\u0123\u0001\u0000\u0000\u0000"+
		"\u0127\u0124\u0001\u0000\u0000\u0000\u0127\u0125\u0001\u0000\u0000\u0000"+
		"\u0127\u0126\u0001\u0000\u0000\u0000\u0128\u0007\u0001\u0000\u0000\u0000"+
		"\u0129\u012f\u0003\n\u0005\u0000\u012a\u012f\u0005\u001e\u0000\u0000\u012b"+
		"\u012f\u0005*\u0000\u0000\u012c\u012f\u0005.\u0000\u0000\u012d\u012f\u0005"+
		"1\u0000\u0000\u012e\u0129\u0001\u0000\u0000\u0000\u012e\u012a\u0001\u0000"+
		"\u0000\u0000\u012e\u012b\u0001\u0000\u0000\u0000\u012e\u012c\u0001\u0000"+
		"\u0000\u0000\u012e\u012d\u0001\u0000\u0000\u0000\u012f\t\u0001\u0000\u0000"+
		"\u0000\u0130\u0139\u0003p8\u0000\u0131\u0139\u0005#\u0000\u0000\u0132"+
		"\u0139\u0005\"\u0000\u0000\u0133\u0139\u0005!\u0000\u0000\u0134\u0139"+
		"\u0005&\u0000\u0000\u0135\u0139\u0005\u0001\u0000\u0000\u0136\u0139\u0005"+
		"\u0012\u0000\u0000\u0137\u0139\u0005\'\u0000\u0000\u0138\u0130\u0001\u0000"+
		"\u0000\u0000\u0138\u0131\u0001\u0000\u0000\u0000\u0138\u0132\u0001\u0000"+
		"\u0000\u0000\u0138\u0133\u0001\u0000\u0000\u0000\u0138\u0134\u0001\u0000"+
		"\u0000\u0000\u0138\u0135\u0001\u0000\u0000\u0000\u0138\u0136\u0001\u0000"+
		"\u0000\u0000\u0138\u0137\u0001\u0000\u0000\u0000\u0139\u000b\u0001\u0000"+
		"\u0000\u0000\u013a\u013d\u0005\u0012\u0000\u0000\u013b\u013d\u0003p8\u0000"+
		"\u013c\u013a\u0001\u0000\u0000\u0000\u013c\u013b\u0001\u0000\u0000\u0000"+
		"\u013d\r\u0001\u0000\u0000\u0000\u013e\u013f\u0005\t\u0000\u0000\u013f"+
		"\u0141\u0003\u0098L\u0000\u0140\u0142\u0003\u0010\b\u0000\u0141\u0140"+
		"\u0001\u0000\u0000\u0000\u0141\u0142\u0001\u0000\u0000\u0000\u0142\u0145"+
		"\u0001\u0000\u0000\u0000\u0143\u0144\u0005\u0011\u0000\u0000\u0144\u0146"+
		"\u0003\u00e6s\u0000\u0145\u0143\u0001\u0000\u0000\u0000\u0145\u0146\u0001"+
		"\u0000\u0000\u0000\u0146\u0149\u0001\u0000\u0000\u0000\u0147\u0148\u0005"+
		"\u0018\u0000\u0000\u0148\u014a\u0003\u00e4r\u0000\u0149\u0147\u0001\u0000"+
		"\u0000\u0000\u0149\u014a\u0001\u0000\u0000\u0000\u014a\u014b\u0001\u0000"+
		"\u0000\u0000\u014b\u014c\u0003 \u0010\u0000\u014c\u000f\u0001\u0000\u0000"+
		"\u0000\u014d\u014e\u0005Y\u0000\u0000\u014e\u0153\u0003\u0012\t\u0000"+
		"\u014f\u0150\u0005U\u0000\u0000\u0150\u0152\u0003\u0012\t\u0000\u0151"+
		"\u014f\u0001\u0000\u0000\u0000\u0152\u0155\u0001\u0000\u0000\u0000\u0153"+
		"\u0151\u0001\u0000\u0000\u0000\u0153\u0154\u0001\u0000\u0000\u0000\u0154"+
		"\u0156\u0001\u0000\u0000\u0000\u0155\u0153\u0001\u0000\u0000\u0000\u0156"+
		"\u0157\u0005X\u0000\u0000\u0157\u0011\u0001\u0000\u0000\u0000\u0158\u015a"+
		"\u0003p8\u0000\u0159\u0158\u0001\u0000\u0000\u0000\u015a\u015d\u0001\u0000"+
		"\u0000\u0000\u015b\u0159\u0001\u0000\u0000\u0000\u015b\u015c\u0001\u0000"+
		"\u0000\u0000\u015c\u015e\u0001\u0000\u0000\u0000\u015d\u015b\u0001\u0000"+
		"\u0000\u0000\u015e\u0167\u0003\u0098L\u0000\u015f\u0163\u0005\u0011\u0000"+
		"\u0000\u0160\u0162\u0003p8\u0000\u0161\u0160\u0001\u0000\u0000\u0000\u0162"+
		"\u0165\u0001\u0000\u0000\u0000\u0163\u0161\u0001\u0000\u0000\u0000\u0163"+
		"\u0164\u0001\u0000\u0000\u0000\u0164\u0166\u0001\u0000\u0000\u0000\u0165"+
		"\u0163\u0001\u0000\u0000\u0000\u0166\u0168\u0003\u0014\n\u0000\u0167\u015f"+
		"\u0001\u0000\u0000\u0000\u0167\u0168\u0001\u0000\u0000\u0000\u0168\u0013"+
		"\u0001\u0000\u0000\u0000\u0169\u016e\u0003\u00e6s\u0000\u016a\u016b\u0005"+
		"j\u0000\u0000\u016b\u016d\u0003\u00e6s\u0000\u016c\u016a\u0001\u0000\u0000"+
		"\u0000\u016d\u0170\u0001\u0000\u0000\u0000\u016e\u016c\u0001\u0000\u0000"+
		"\u0000\u016e\u016f\u0001\u0000\u0000\u0000\u016f\u0015\u0001\u0000\u0000"+
		"\u0000\u0170\u016e\u0001\u0000\u0000\u0000\u0171\u0172\u0005\u0010\u0000"+
		"\u0000\u0172\u0175\u0003\u0098L\u0000\u0173\u0174\u0005\u0018\u0000\u0000"+
		"\u0174\u0176\u0003\u00e4r\u0000\u0175\u0173\u0001\u0000\u0000\u0000\u0175"+
		"\u0176\u0001\u0000\u0000\u0000\u0176\u0177\u0001\u0000\u0000\u0000\u0177"+
		"\u0179\u0005P\u0000\u0000\u0178\u017a\u0003\u0018\f\u0000\u0179\u0178"+
		"\u0001\u0000\u0000\u0000\u0179\u017a\u0001\u0000\u0000\u0000\u017a\u017c"+
		"\u0001\u0000\u0000\u0000\u017b\u017d\u0005U\u0000\u0000\u017c\u017b\u0001"+
		"\u0000\u0000\u0000\u017c\u017d\u0001\u0000\u0000\u0000\u017d\u017f\u0001"+
		"\u0000\u0000\u0000\u017e\u0180\u0003\u001c\u000e\u0000\u017f\u017e\u0001"+
		"\u0000\u0000\u0000\u017f\u0180\u0001\u0000\u0000\u0000\u0180\u0181\u0001"+
		"\u0000\u0000\u0000\u0181\u0182\u0005Q\u0000\u0000\u0182\u0017\u0001\u0000"+
		"\u0000\u0000\u0183\u0188\u0003\u001a\r\u0000\u0184\u0185\u0005U\u0000"+
		"\u0000\u0185\u0187\u0003\u001a\r\u0000\u0186\u0184\u0001\u0000\u0000\u0000"+
		"\u0187\u018a\u0001\u0000\u0000\u0000\u0188\u0186\u0001\u0000\u0000\u0000"+
		"\u0188\u0189\u0001\u0000\u0000\u0000\u0189\u0019\u0001\u0000\u0000\u0000"+
		"\u018a\u0188\u0001\u0000\u0000\u0000\u018b\u018d\u0003p8\u0000\u018c\u018b"+
		"\u0001\u0000\u0000\u0000\u018d\u0190\u0001\u0000\u0000\u0000\u018e\u018c"+
		"\u0001\u0000\u0000\u0000\u018e\u018f\u0001\u0000\u0000\u0000\u018f\u0191"+
		"\u0001\u0000\u0000\u0000\u0190\u018e\u0001\u0000\u0000\u0000\u0191\u0193"+
		"\u0003\u0098L\u0000\u0192\u0194\u0003\u00f0x\u0000\u0193\u0192\u0001\u0000"+
		"\u0000\u0000\u0193\u0194\u0001\u0000\u0000\u0000\u0194\u0196\u0001\u0000"+
		"\u0000\u0000\u0195\u0197\u0003 \u0010\u0000\u0196\u0195\u0001\u0000\u0000"+
		"\u0000\u0196\u0197\u0001\u0000\u0000\u0000\u0197\u001b\u0001\u0000\u0000"+
		"\u0000\u0198\u019c\u0005T\u0000\u0000\u0199\u019b\u0003$\u0012\u0000\u019a"+
		"\u0199\u0001\u0000\u0000\u0000\u019b\u019e\u0001\u0000\u0000\u0000\u019c"+
		"\u019a\u0001\u0000\u0000\u0000\u019c\u019d\u0001\u0000\u0000\u0000\u019d"+
		"\u001d\u0001\u0000\u0000\u0000\u019e\u019c\u0001\u0000\u0000\u0000\u019f"+
		"\u01a0\u0005\u001c\u0000\u0000\u01a0\u01a2\u0003\u0098L\u0000\u01a1\u01a3"+
		"\u0003\u0010\b\u0000\u01a2\u01a1\u0001\u0000\u0000\u0000\u01a2\u01a3\u0001"+
		"\u0000\u0000\u0000\u01a3\u01a6\u0001\u0000\u0000\u0000\u01a4\u01a5\u0005"+
		"\u0011\u0000\u0000\u01a5\u01a7\u0003\u00e4r\u0000\u01a6\u01a4\u0001\u0000"+
		"\u0000\u0000\u01a6\u01a7\u0001\u0000\u0000\u0000\u01a7\u01aa\u0001\u0000"+
		"\u0000\u0000\u01a8\u01a9\u0005A\u0000\u0000\u01a9\u01ab\u0003\u00e4r\u0000"+
		"\u01aa\u01a8\u0001\u0000\u0000\u0000\u01aa\u01ab\u0001\u0000\u0000\u0000"+
		"\u01ab\u01ac\u0001\u0000\u0000\u0000\u01ac\u01ad\u0003\"\u0011\u0000\u01ad"+
		"\u001f\u0001\u0000\u0000\u0000\u01ae\u01b2\u0005P\u0000\u0000\u01af\u01b1"+
		"\u0003$\u0012\u0000\u01b0\u01af\u0001\u0000\u0000\u0000\u01b1\u01b4\u0001"+
		"\u0000\u0000\u0000\u01b2\u01b0\u0001\u0000\u0000\u0000\u01b2\u01b3\u0001"+
		"\u0000\u0000\u0000\u01b3\u01b5\u0001\u0000\u0000\u0000\u01b4\u01b2\u0001"+
		"\u0000\u0000\u0000\u01b5\u01b6\u0005Q\u0000\u0000\u01b6!\u0001\u0000\u0000"+
		"\u0000\u01b7\u01bb\u0005P\u0000\u0000\u01b8\u01ba\u00038\u001c\u0000\u01b9"+
		"\u01b8\u0001\u0000\u0000\u0000\u01ba\u01bd\u0001\u0000\u0000\u0000\u01bb"+
		"\u01b9\u0001\u0000\u0000\u0000\u01bb\u01bc\u0001\u0000\u0000\u0000\u01bc"+
		"\u01be\u0001\u0000\u0000\u0000\u01bd\u01bb\u0001\u0000\u0000\u0000\u01be"+
		"\u01bf\u0005Q\u0000\u0000\u01bf#\u0001\u0000\u0000\u0000\u01c0\u01cd\u0005"+
		"T\u0000\u0000\u01c1\u01c3\u0005&\u0000\u0000\u01c2\u01c1\u0001\u0000\u0000"+
		"\u0000\u01c2\u01c3\u0001\u0000\u0000\u0000\u01c3\u01c4\u0001\u0000\u0000"+
		"\u0000\u01c4\u01cd\u0003\u0092I\u0000\u01c5\u01c7\u0003\b\u0004\u0000"+
		"\u01c6\u01c5\u0001\u0000\u0000\u0000\u01c7\u01ca\u0001\u0000\u0000\u0000"+
		"\u01c8\u01c6\u0001\u0000\u0000\u0000\u01c8\u01c9\u0001\u0000\u0000\u0000"+
		"\u01c9\u01cb\u0001\u0000\u0000\u0000\u01ca\u01c8\u0001\u0000\u0000\u0000"+
		"\u01cb\u01cd\u0003&\u0013\u0000\u01cc\u01c0\u0001\u0000\u0000\u0000\u01cc"+
		"\u01c2\u0001\u0000\u0000\u0000\u01cc\u01c8\u0001\u0000\u0000\u0000\u01cd"+
		"%\u0001\u0000\u0000\u0000\u01ce\u01d8\u0003(\u0014\u0000\u01cf\u01d8\u0003"+
		".\u0017\u0000\u01d0\u01d8\u00036\u001b\u0000\u01d1\u01d8\u00032\u0019"+
		"\u0000\u01d2\u01d8\u00030\u0018\u0000\u01d3\u01d8\u0003\u001e\u000f\u0000"+
		"\u01d4\u01d8\u0003z=\u0000\u01d5\u01d8\u0003\u000e\u0007\u0000\u01d6\u01d8"+
		"\u0003\u0016\u000b\u0000\u01d7\u01ce\u0001\u0000\u0000\u0000\u01d7\u01cf"+
		"\u0001\u0000\u0000\u0000\u01d7\u01d0\u0001\u0000\u0000\u0000\u01d7\u01d1"+
		"\u0001\u0000\u0000\u0000\u01d7\u01d2\u0001\u0000\u0000\u0000\u01d7\u01d3"+
		"\u0001\u0000\u0000\u0000\u01d7\u01d4\u0001\u0000\u0000\u0000\u01d7\u01d5"+
		"\u0001\u0000\u0000\u0000\u01d7\u01d6\u0001\u0000\u0000\u0000\u01d8\'\u0001"+
		"\u0000\u0000\u0000\u01d9\u01da\u0003,\u0016\u0000\u01da\u01db\u0003\u0098"+
		"L\u0000\u01db\u01e0\u0003X,\u0000\u01dc\u01dd\u0005R\u0000\u0000\u01dd"+
		"\u01df\u0005S\u0000\u0000\u01de\u01dc\u0001\u0000\u0000\u0000\u01df\u01e2"+
		"\u0001\u0000\u0000\u0000\u01e0\u01de\u0001\u0000\u0000\u0000\u01e0\u01e1"+
		"\u0001\u0000\u0000\u0000\u01e1\u01e5\u0001\u0000\u0000\u0000\u01e2\u01e0"+
		"\u0001\u0000\u0000\u0000\u01e3\u01e4\u0005-\u0000\u0000\u01e4\u01e6\u0003"+
		"V+\u0000\u01e5\u01e3\u0001\u0000\u0000\u0000\u01e5\u01e6\u0001\u0000\u0000"+
		"\u0000\u01e6\u01e7\u0001\u0000\u0000\u0000\u01e7\u01e8\u0003*\u0015\u0000"+
		"\u01e8)\u0001\u0000\u0000\u0000\u01e9\u01ec\u0003\u0092I\u0000\u01ea\u01ec"+
		"\u0005T\u0000\u0000\u01eb\u01e9\u0001\u0000\u0000\u0000\u01eb\u01ea\u0001"+
		"\u0000\u0000\u0000\u01ec+\u0001\u0000\u0000\u0000\u01ed\u01f0\u0003\u00e6"+
		"s\u0000\u01ee\u01f0\u00050\u0000\u0000\u01ef\u01ed\u0001\u0000\u0000\u0000"+
		"\u01ef\u01ee\u0001\u0000\u0000\u0000\u01f0-\u0001\u0000\u0000\u0000\u01f1"+
		"\u01f2\u0003\u0010\b\u0000\u01f2\u01f3\u0003(\u0014\u0000\u01f3/\u0001"+
		"\u0000\u0000\u0000\u01f4\u01f5\u0003\u0010\b\u0000\u01f5\u01f6\u00032"+
		"\u0019\u0000\u01f61\u0001\u0000\u0000\u0000\u01f7\u01f8\u0003\u0098L\u0000"+
		"\u01f8\u01fb\u0003X,\u0000\u01f9\u01fa\u0005-\u0000\u0000\u01fa\u01fc"+
		"\u0003V+\u0000\u01fb\u01f9\u0001\u0000\u0000\u0000\u01fb\u01fc\u0001\u0000"+
		"\u0000\u0000\u01fc\u01fd\u0001\u0000\u0000\u0000\u01fd\u01fe\u0003\u0092"+
		"I\u0000\u01fe3\u0001\u0000\u0000\u0000\u01ff\u0201\u0003\b\u0004\u0000"+
		"\u0200\u01ff\u0001\u0000\u0000\u0000\u0201\u0204\u0001\u0000\u0000\u0000"+
		"\u0202\u0200\u0001\u0000\u0000\u0000\u0202\u0203\u0001\u0000\u0000\u0000"+
		"\u0203\u0205\u0001\u0000\u0000\u0000\u0204\u0202\u0001\u0000\u0000\u0000"+
		"\u0205\u0206\u0003\u0098L\u0000\u0206\u0207\u0003\u0092I\u0000\u02075"+
		"\u0001\u0000\u0000\u0000\u0208\u0209\u0003\u00e6s\u0000\u0209\u020a\u0003"+
		"H$\u0000\u020a\u020b\u0005T\u0000\u0000\u020b7\u0001\u0000\u0000\u0000"+
		"\u020c\u020e\u0003\b\u0004\u0000\u020d\u020c\u0001\u0000\u0000\u0000\u020e"+
		"\u0211\u0001\u0000\u0000\u0000\u020f\u020d\u0001\u0000\u0000\u0000\u020f"+
		"\u0210\u0001\u0000\u0000\u0000\u0210\u0212\u0001\u0000\u0000\u0000\u0211"+
		"\u020f\u0001\u0000\u0000\u0000\u0212\u0215\u0003:\u001d\u0000\u0213\u0215"+
		"\u0005T\u0000\u0000\u0214\u020f\u0001\u0000\u0000\u0000\u0214\u0213\u0001"+
		"\u0000\u0000\u0000\u02159\u0001\u0000\u0000\u0000\u0216\u021e\u0003<\u001e"+
		"\u0000\u0217\u021e\u0003@ \u0000\u0218\u021e\u0003D\"\u0000\u0219\u021e"+
		"\u0003\u001e\u000f\u0000\u021a\u021e\u0003z=\u0000\u021b\u021e\u0003\u000e"+
		"\u0007\u0000\u021c\u021e\u0003\u0016\u000b\u0000\u021d\u0216\u0001\u0000"+
		"\u0000\u0000\u021d\u0217\u0001\u0000\u0000\u0000\u021d\u0218\u0001\u0000"+
		"\u0000\u0000\u021d\u0219\u0001\u0000\u0000\u0000\u021d\u021a\u0001\u0000"+
		"\u0000\u0000\u021d\u021b\u0001\u0000\u0000\u0000\u021d\u021c\u0001\u0000"+
		"\u0000\u0000\u021e;\u0001\u0000\u0000\u0000\u021f\u0220\u0003\u00e6s\u0000"+
		"\u0220\u0225\u0003>\u001f\u0000\u0221\u0222\u0005U\u0000\u0000\u0222\u0224"+
		"\u0003>\u001f\u0000\u0223\u0221\u0001\u0000\u0000\u0000\u0224\u0227\u0001"+
		"\u0000\u0000\u0000\u0225\u0223\u0001\u0000\u0000\u0000\u0225\u0226\u0001"+
		"\u0000\u0000\u0000\u0226\u0228\u0001\u0000\u0000\u0000\u0227\u0225\u0001"+
		"\u0000\u0000\u0000\u0228\u0229\u0005T\u0000\u0000\u0229=\u0001\u0000\u0000"+
		"\u0000\u022a\u022f\u0003\u0098L\u0000\u022b\u022c\u0005R\u0000\u0000\u022c"+
		"\u022e\u0005S\u0000\u0000\u022d\u022b\u0001\u0000\u0000\u0000\u022e\u0231"+
		"\u0001\u0000\u0000\u0000\u022f\u022d\u0001\u0000\u0000\u0000\u022f\u0230"+
		"\u0001\u0000\u0000\u0000\u0230\u0232\u0001\u0000\u0000\u0000\u0231\u022f"+
		"\u0001\u0000\u0000\u0000\u0232\u0233\u0005W\u0000\u0000\u0233\u0234\u0003"+
		"N\'\u0000\u0234?\u0001\u0000\u0000\u0000\u0235\u0237\u0003B!\u0000\u0236"+
		"\u0235\u0001\u0000\u0000\u0000\u0237\u023a\u0001\u0000\u0000\u0000\u0238"+
		"\u0236\u0001\u0000\u0000\u0000\u0238\u0239\u0001\u0000\u0000\u0000\u0239"+
		"\u023b\u0001\u0000\u0000\u0000\u023a\u0238\u0001\u0000\u0000\u0000\u023b"+
		"\u023c\u0003F#\u0000\u023cA\u0001\u0000\u0000\u0000\u023d\u0244\u0003"+
		"p8\u0000\u023e\u0244\u0005#\u0000\u0000\u023f\u0244\u0005\u0001\u0000"+
		"\u0000\u0240\u0244\u0005\f\u0000\u0000\u0241\u0244\u0005&\u0000\u0000"+
		"\u0242\u0244\u0005\'\u0000\u0000\u0243\u023d\u0001\u0000\u0000\u0000\u0243"+
		"\u023e\u0001\u0000\u0000\u0000\u0243\u023f\u0001\u0000\u0000\u0000\u0243"+
		"\u0240\u0001\u0000\u0000\u0000\u0243\u0241\u0001\u0000\u0000\u0000\u0243"+
		"\u0242\u0001\u0000\u0000\u0000\u0244C\u0001\u0000\u0000\u0000\u0245\u0247"+
		"\u0003B!\u0000\u0246\u0245\u0001\u0000\u0000\u0000\u0247\u024a\u0001\u0000"+
		"\u0000\u0000\u0248\u0246\u0001\u0000\u0000\u0000\u0248\u0249\u0001\u0000"+
		"\u0000\u0000\u0249\u024b\u0001\u0000\u0000\u0000\u024a\u0248\u0001\u0000"+
		"\u0000\u0000\u024b\u024c\u0003\u0010\b\u0000\u024c\u024d\u0003F#\u0000"+
		"\u024dE\u0001\u0000\u0000\u0000\u024e\u0250\u0003p8\u0000\u024f\u024e"+
		"\u0001\u0000\u0000\u0000\u0250\u0253\u0001\u0000\u0000\u0000\u0251\u024f"+
		"\u0001\u0000\u0000\u0000\u0251\u0252\u0001\u0000\u0000\u0000\u0252\u0254"+
		"\u0001\u0000\u0000\u0000\u0253\u0251\u0001\u0000\u0000\u0000\u0254\u0255"+
		"\u0003,\u0016\u0000\u0255\u0256\u0003\u0098L\u0000\u0256\u025b\u0003X"+
		",\u0000\u0257\u0258\u0005R\u0000\u0000\u0258\u025a\u0005S\u0000\u0000"+
		"\u0259\u0257\u0001\u0000\u0000\u0000\u025a\u025d\u0001\u0000\u0000\u0000"+
		"\u025b\u0259\u0001\u0000\u0000\u0000\u025b\u025c\u0001\u0000\u0000\u0000"+
		"\u025c\u0260\u0001\u0000\u0000\u0000\u025d\u025b\u0001\u0000\u0000\u0000"+
		"\u025e\u025f\u0005-\u0000\u0000\u025f\u0261\u0003V+\u0000\u0260\u025e"+
		"\u0001\u0000\u0000\u0000\u0260\u0261\u0001\u0000\u0000\u0000\u0261\u0262"+
		"\u0001\u0000\u0000\u0000\u0262\u0263\u0003*\u0015\u0000\u0263G\u0001\u0000"+
		"\u0000\u0000\u0264\u0269\u0003J%\u0000\u0265\u0266\u0005U\u0000\u0000"+
		"\u0266\u0268\u0003J%\u0000\u0267\u0265\u0001\u0000\u0000\u0000\u0268\u026b"+
		"\u0001\u0000\u0000\u0000\u0269\u0267\u0001\u0000\u0000\u0000\u0269\u026a"+
		"\u0001\u0000\u0000\u0000\u026aI\u0001\u0000\u0000\u0000\u026b\u0269\u0001"+
		"\u0000\u0000\u0000\u026c\u026f\u0003L&\u0000\u026d\u026e\u0005W\u0000"+
		"\u0000\u026e\u0270\u0003N\'\u0000\u026f\u026d\u0001\u0000\u0000\u0000"+
		"\u026f\u0270\u0001\u0000\u0000\u0000\u0270K\u0001\u0000\u0000\u0000\u0271"+
		"\u0276\u0003\u0098L\u0000\u0272\u0273\u0005R\u0000\u0000\u0273\u0275\u0005"+
		"S\u0000\u0000\u0274\u0272\u0001\u0000\u0000\u0000\u0275\u0278\u0001\u0000"+
		"\u0000\u0000\u0276\u0274\u0001\u0000\u0000\u0000\u0276\u0277\u0001\u0000"+
		"\u0000\u0000\u0277M\u0001\u0000\u0000\u0000\u0278\u0276\u0001\u0000\u0000"+
		"\u0000\u0279\u027c\u0003P(\u0000\u027a\u027c\u0003\u00bc^\u0000\u027b"+
		"\u0279\u0001\u0000\u0000\u0000\u027b\u027a\u0001\u0000\u0000\u0000\u027c"+
		"O\u0001\u0000\u0000\u0000\u027d\u0289\u0005P\u0000\u0000\u027e\u0283\u0003"+
		"N\'\u0000\u027f\u0280\u0005U\u0000\u0000\u0280\u0282\u0003N\'\u0000\u0281"+
		"\u027f\u0001\u0000\u0000\u0000\u0282\u0285\u0001\u0000\u0000\u0000\u0283"+
		"\u0281\u0001\u0000\u0000\u0000\u0283\u0284\u0001\u0000\u0000\u0000\u0284"+
		"\u0287\u0001\u0000\u0000\u0000\u0285\u0283\u0001\u0000\u0000\u0000\u0286"+
		"\u0288\u0005U\u0000\u0000\u0287\u0286\u0001\u0000\u0000\u0000\u0287\u0288"+
		"\u0001\u0000\u0000\u0000\u0288\u028a\u0001\u0000\u0000\u0000\u0289\u027e"+
		"\u0001\u0000\u0000\u0000\u0289\u028a\u0001\u0000\u0000\u0000\u028a\u028b"+
		"\u0001\u0000\u0000\u0000\u028b\u028c\u0005Q\u0000\u0000\u028cQ\u0001\u0000"+
		"\u0000\u0000\u028d\u028f\u0003\u0098L\u0000\u028e\u0290\u0003\u00eau\u0000"+
		"\u028f\u028e\u0001\u0000\u0000\u0000\u028f\u0290\u0001\u0000\u0000\u0000"+
		"\u0290\u0291\u0001\u0000\u0000\u0000\u0291\u0292\u0005V\u0000\u0000\u0292"+
		"\u0294\u0001\u0000\u0000\u0000\u0293\u028d\u0001\u0000\u0000\u0000\u0294"+
		"\u0297\u0001\u0000\u0000\u0000\u0295\u0293\u0001\u0000\u0000\u0000\u0295"+
		"\u0296\u0001\u0000\u0000\u0000\u0296\u0298\u0001\u0000\u0000\u0000\u0297"+
		"\u0295\u0001\u0000\u0000\u0000\u0298\u029a\u0003\u009aM\u0000\u0299\u029b"+
		"\u0003\u00eau\u0000\u029a\u0299\u0001\u0000\u0000\u0000\u029a\u029b\u0001"+
		"\u0000\u0000\u0000\u029bS\u0001\u0000\u0000\u0000\u029c\u02a9\u0003\u00e6"+
		"s\u0000\u029d\u029f\u0003p8\u0000\u029e\u029d\u0001\u0000\u0000\u0000"+
		"\u029f\u02a2\u0001\u0000\u0000\u0000\u02a0\u029e\u0001\u0000\u0000\u0000"+
		"\u02a0\u02a1\u0001\u0000\u0000\u0000\u02a1\u02a3\u0001\u0000\u0000\u0000"+
		"\u02a2\u02a0\u0001\u0000\u0000\u0000\u02a3\u02a6\u0005\\\u0000\u0000\u02a4"+
		"\u02a5\u0007\u0000\u0000\u0000\u02a5\u02a7\u0003\u00e6s\u0000\u02a6\u02a4"+
		"\u0001\u0000\u0000\u0000\u02a6\u02a7\u0001\u0000\u0000\u0000\u02a7\u02a9"+
		"\u0001\u0000\u0000\u0000\u02a8\u029c\u0001\u0000\u0000\u0000\u02a8\u02a0"+
		"\u0001\u0000\u0000\u0000\u02a9U\u0001\u0000\u0000\u0000\u02aa\u02af\u0003"+
		"f3\u0000\u02ab\u02ac\u0005U\u0000\u0000\u02ac\u02ae\u0003f3\u0000\u02ad"+
		"\u02ab\u0001\u0000\u0000\u0000\u02ae\u02b1\u0001\u0000\u0000\u0000\u02af"+
		"\u02ad\u0001\u0000\u0000\u0000\u02af\u02b0\u0001\u0000\u0000\u0000\u02b0"+
		"W\u0001\u0000\u0000\u0000\u02b1\u02af\u0001\u0000\u0000\u0000\u02b2\u02be"+
		"\u0005N\u0000\u0000\u02b3\u02b5\u0003Z-\u0000\u02b4\u02b3\u0001\u0000"+
		"\u0000\u0000\u02b4\u02b5\u0001\u0000\u0000\u0000\u02b5\u02bf\u0001\u0000"+
		"\u0000\u0000\u02b6\u02b9\u0003Z-\u0000\u02b7\u02b8\u0005U\u0000\u0000"+
		"\u02b8\u02ba\u0003\\.\u0000\u02b9\u02b7\u0001\u0000\u0000\u0000\u02b9"+
		"\u02ba\u0001\u0000\u0000\u0000\u02ba\u02bf\u0001\u0000\u0000\u0000\u02bb"+
		"\u02bd\u0003\\.\u0000\u02bc\u02bb\u0001\u0000\u0000\u0000\u02bc\u02bd"+
		"\u0001\u0000\u0000\u0000\u02bd\u02bf\u0001\u0000\u0000\u0000\u02be\u02b4"+
		"\u0001\u0000\u0000\u0000\u02be\u02b6\u0001\u0000\u0000\u0000\u02be\u02bc"+
		"\u0001\u0000\u0000\u0000\u02bf\u02c0\u0001\u0000\u0000\u0000\u02c0\u02c1"+
		"\u0005O\u0000\u0000\u02c1Y\u0001\u0000\u0000\u0000\u02c2\u02c8\u0003\u00e6"+
		"s\u0000\u02c3\u02c4\u0003\u0098L\u0000\u02c4\u02c5\u0005V\u0000\u0000"+
		"\u02c5\u02c7\u0001\u0000\u0000\u0000\u02c6\u02c3\u0001\u0000\u0000\u0000"+
		"\u02c7\u02ca\u0001\u0000\u0000\u0000\u02c8\u02c6\u0001\u0000\u0000\u0000"+
		"\u02c8\u02c9\u0001\u0000\u0000\u0000\u02c9\u02cb\u0001\u0000\u0000\u0000"+
		"\u02ca\u02c8\u0001\u0000\u0000\u0000\u02cb\u02cc\u0005+\u0000\u0000\u02cc"+
		"[\u0001\u0000\u0000\u0000\u02cd\u02d2\u0003^/\u0000\u02ce\u02cf\u0005"+
		"U\u0000\u0000\u02cf\u02d1\u0003^/\u0000\u02d0\u02ce\u0001\u0000\u0000"+
		"\u0000\u02d1\u02d4\u0001\u0000\u0000\u0000\u02d2\u02d0\u0001\u0000\u0000"+
		"\u0000\u02d2\u02d3\u0001\u0000\u0000\u0000\u02d3\u02d7\u0001\u0000\u0000"+
		"\u0000\u02d4\u02d2\u0001\u0000\u0000\u0000\u02d5\u02d6\u0005U\u0000\u0000"+
		"\u02d6\u02d8\u0003`0\u0000\u02d7\u02d5\u0001\u0000\u0000\u0000\u02d7\u02d8"+
		"\u0001\u0000\u0000\u0000\u02d8\u02db\u0001\u0000\u0000\u0000\u02d9\u02db"+
		"\u0003`0\u0000\u02da\u02cd\u0001\u0000\u0000\u0000\u02da\u02d9\u0001\u0000"+
		"\u0000\u0000\u02db]\u0001\u0000\u0000\u0000\u02dc\u02de\u0003\f\u0006"+
		"\u0000\u02dd\u02dc\u0001\u0000\u0000\u0000\u02de\u02e1\u0001\u0000\u0000"+
		"\u0000\u02df\u02dd\u0001\u0000\u0000\u0000\u02df\u02e0\u0001\u0000\u0000"+
		"\u0000\u02e0\u02e2\u0001\u0000\u0000\u0000\u02e1\u02df\u0001\u0000\u0000"+
		"\u0000\u02e2\u02e3\u0003\u00e6s\u0000\u02e3\u02e4\u0003L&\u0000\u02e4"+
		"_\u0001\u0000\u0000\u0000\u02e5\u02e7\u0003\f\u0006\u0000\u02e6\u02e5"+
		"\u0001\u0000\u0000\u0000\u02e7\u02ea\u0001\u0000\u0000\u0000\u02e8\u02e6"+
		"\u0001\u0000\u0000\u0000\u02e8\u02e9\u0001\u0000\u0000\u0000\u02e9\u02eb"+
		"\u0001\u0000\u0000\u0000\u02ea\u02e8\u0001\u0000\u0000\u0000\u02eb\u02ef"+
		"\u0003\u00e6s\u0000\u02ec\u02ee\u0003p8\u0000\u02ed\u02ec\u0001\u0000"+
		"\u0000\u0000\u02ee\u02f1\u0001\u0000\u0000\u0000\u02ef\u02ed\u0001\u0000"+
		"\u0000\u0000\u02ef\u02f0\u0001\u0000\u0000\u0000\u02f0\u02f2\u0001\u0000"+
		"\u0000\u0000\u02f1\u02ef\u0001\u0000\u0000\u0000\u02f2\u02f3\u0005|\u0000"+
		"\u0000\u02f3\u02f4\u0003L&\u0000\u02f4a\u0001\u0000\u0000\u0000\u02f5"+
		"\u02fa\u0003d2\u0000\u02f6\u02f7\u0005U\u0000\u0000\u02f7\u02f9\u0003"+
		"d2\u0000\u02f8\u02f6\u0001\u0000\u0000\u0000\u02f9\u02fc\u0001\u0000\u0000"+
		"\u0000\u02fa\u02f8\u0001\u0000\u0000\u0000\u02fa\u02fb\u0001\u0000\u0000"+
		"\u0000\u02fbc\u0001\u0000\u0000\u0000\u02fc\u02fa\u0001\u0000\u0000\u0000"+
		"\u02fd\u02ff\u0003\f\u0006\u0000\u02fe\u02fd\u0001\u0000\u0000\u0000\u02ff"+
		"\u0302\u0001\u0000\u0000\u0000\u0300\u02fe\u0001\u0000\u0000\u0000\u0300"+
		"\u0301\u0001\u0000\u0000\u0000\u0301\u0303\u0001\u0000\u0000\u0000\u0302"+
		"\u0300\u0001\u0000\u0000\u0000\u0303\u0304\u0005=\u0000\u0000\u0304\u0305"+
		"\u0003\u0098L\u0000\u0305e\u0001\u0000\u0000\u0000\u0306\u030b\u0003\u0098"+
		"L\u0000\u0307\u0308\u0005V\u0000\u0000\u0308\u030a\u0003\u0098L\u0000"+
		"\u0309\u0307\u0001\u0000\u0000\u0000\u030a\u030d\u0001\u0000\u0000\u0000"+
		"\u030b\u0309\u0001\u0000\u0000\u0000\u030b\u030c\u0001\u0000\u0000\u0000"+
		"\u030cg\u0001\u0000\u0000\u0000\u030d\u030b\u0001\u0000\u0000\u0000\u030e"+
		"\u0316\u0003j5\u0000\u030f\u0316\u0003l6\u0000\u0310\u0316\u0005J\u0000"+
		"\u0000\u0311\u0316\u0005K\u0000\u0000\u0312\u0316\u0005I\u0000\u0000\u0313"+
		"\u0316\u0005M\u0000\u0000\u0314\u0316\u0005L\u0000\u0000\u0315\u030e\u0001"+
		"\u0000\u0000\u0000\u0315\u030f\u0001\u0000\u0000\u0000\u0315\u0310\u0001"+
		"\u0000\u0000\u0000\u0315\u0311\u0001\u0000\u0000\u0000\u0315\u0312\u0001"+
		"\u0000\u0000\u0000\u0315\u0313\u0001\u0000\u0000\u0000\u0315\u0314\u0001"+
		"\u0000\u0000\u0000\u0316i\u0001\u0000\u0000\u0000\u0317\u0318\u0007\u0001"+
		"\u0000\u0000\u0318k\u0001\u0000\u0000\u0000\u0319\u031a\u0007\u0002\u0000"+
		"\u0000\u031am\u0001\u0000\u0000\u0000\u031b\u031c\u0003\u0098L\u0000\u031c"+
		"\u031d\u0005V\u0000\u0000\u031d\u031f\u0001\u0000\u0000\u0000\u031e\u031b"+
		"\u0001\u0000\u0000\u0000\u031f\u0322\u0001\u0000\u0000\u0000\u0320\u031e"+
		"\u0001\u0000\u0000\u0000\u0320\u0321\u0001\u0000\u0000\u0000\u0321\u0323"+
		"\u0001\u0000\u0000\u0000\u0322\u0320\u0001\u0000\u0000\u0000\u0323\u0324"+
		"\u0005{\u0000\u0000\u0324\u0325\u0003\u0098L\u0000\u0325o\u0001\u0000"+
		"\u0000\u0000\u0326\u0327\u0005{\u0000\u0000\u0327\u032a\u0003f3\u0000"+
		"\u0328\u032a\u0003n7\u0000\u0329\u0326\u0001\u0000\u0000\u0000\u0329\u0328"+
		"\u0001\u0000\u0000\u0000\u032a\u0331\u0001\u0000\u0000\u0000\u032b\u032e"+
		"\u0005N\u0000\u0000\u032c\u032f\u0003r9\u0000\u032d\u032f\u0003v;\u0000"+
		"\u032e\u032c\u0001\u0000\u0000\u0000\u032e\u032d\u0001\u0000\u0000\u0000"+
		"\u032e\u032f\u0001\u0000\u0000\u0000\u032f\u0330\u0001\u0000\u0000\u0000"+
		"\u0330\u0332\u0005O\u0000\u0000\u0331\u032b\u0001\u0000\u0000\u0000\u0331"+
		"\u0332\u0001\u0000\u0000\u0000\u0332q\u0001\u0000\u0000\u0000\u0333\u0338"+
		"\u0003t:\u0000\u0334\u0335\u0005U\u0000\u0000\u0335\u0337\u0003t:\u0000"+
		"\u0336\u0334\u0001\u0000\u0000\u0000\u0337\u033a\u0001\u0000\u0000\u0000"+
		"\u0338\u0336\u0001\u0000\u0000\u0000\u0338\u0339\u0001\u0000\u0000\u0000"+
		"\u0339s\u0001\u0000\u0000\u0000\u033a\u0338\u0001\u0000\u0000\u0000\u033b"+
		"\u033c\u0003\u0098L\u0000\u033c\u033d\u0005W\u0000\u0000\u033d\u033e\u0003"+
		"v;\u0000\u033eu\u0001\u0000\u0000\u0000\u033f\u0343\u0003\u00bc^\u0000"+
		"\u0340\u0343\u0003p8\u0000\u0341\u0343\u0003x<\u0000\u0342\u033f\u0001"+
		"\u0000\u0000\u0000\u0342\u0340\u0001\u0000\u0000\u0000\u0342\u0341\u0001"+
		"\u0000\u0000\u0000\u0343w\u0001\u0000\u0000\u0000\u0344\u034d\u0005P\u0000"+
		"\u0000\u0345\u034a\u0003v;\u0000\u0346\u0347\u0005U\u0000\u0000\u0347"+
		"\u0349\u0003v;\u0000\u0348\u0346\u0001\u0000\u0000\u0000\u0349\u034c\u0001"+
		"\u0000\u0000\u0000\u034a\u0348\u0001\u0000\u0000\u0000\u034a\u034b\u0001"+
		"\u0000\u0000\u0000\u034b\u034e\u0001\u0000\u0000\u0000\u034c\u034a\u0001"+
		"\u0000\u0000\u0000\u034d\u0345\u0001\u0000\u0000\u0000\u034d\u034e\u0001"+
		"\u0000\u0000\u0000\u034e\u0350\u0001\u0000\u0000\u0000\u034f\u0351\u0005"+
		"U\u0000\u0000\u0350\u034f\u0001\u0000\u0000\u0000\u0350\u0351\u0001\u0000"+
		"\u0000\u0000\u0351\u0352\u0001\u0000\u0000\u0000\u0352\u0353\u0005Q\u0000"+
		"\u0000\u0353y\u0001\u0000\u0000\u0000\u0354\u0355\u0005{\u0000\u0000\u0355"+
		"\u0356\u0005\u001c\u0000\u0000\u0356\u0357\u0003\u0098L\u0000\u0357\u0358"+
		"\u0003|>\u0000\u0358{\u0001\u0000\u0000\u0000\u0359\u035d\u0005P\u0000"+
		"\u0000\u035a\u035c\u0003~?\u0000\u035b\u035a\u0001\u0000\u0000\u0000\u035c"+
		"\u035f\u0001\u0000\u0000\u0000\u035d\u035b\u0001\u0000\u0000\u0000\u035d"+
		"\u035e\u0001\u0000\u0000\u0000\u035e\u0360\u0001\u0000\u0000\u0000\u035f"+
		"\u035d\u0001\u0000\u0000\u0000\u0360\u0361\u0005Q\u0000\u0000\u0361}\u0001"+
		"\u0000\u0000\u0000\u0362\u0364\u0003\b\u0004\u0000\u0363\u0362\u0001\u0000"+
		"\u0000\u0000\u0364\u0367\u0001\u0000\u0000\u0000\u0365\u0363\u0001\u0000"+
		"\u0000\u0000\u0365\u0366\u0001\u0000\u0000\u0000\u0366\u0368\u0001\u0000"+
		"\u0000\u0000\u0367\u0365\u0001\u0000\u0000\u0000\u0368\u036b\u0003\u0080"+
		"@\u0000\u0369\u036b\u0005T\u0000\u0000\u036a\u0365\u0001\u0000\u0000\u0000"+
		"\u036a\u0369\u0001\u0000\u0000\u0000\u036b\u007f\u0001\u0000\u0000\u0000"+
		"\u036c\u036d\u0003\u00e6s\u0000\u036d\u036e\u0003\u0082A\u0000\u036e\u036f"+
		"\u0005T\u0000\u0000\u036f\u0381\u0001\u0000\u0000\u0000\u0370\u0372\u0003"+
		"\u000e\u0007\u0000\u0371\u0373\u0005T\u0000\u0000\u0372\u0371\u0001\u0000"+
		"\u0000\u0000\u0372\u0373\u0001\u0000\u0000\u0000\u0373\u0381\u0001\u0000"+
		"\u0000\u0000\u0374\u0376\u0003\u001e\u000f\u0000\u0375\u0377\u0005T\u0000"+
		"\u0000\u0376\u0375\u0001\u0000\u0000\u0000\u0376\u0377\u0001\u0000\u0000"+
		"\u0000\u0377\u0381\u0001\u0000\u0000\u0000\u0378\u037a\u0003\u0016\u000b"+
		"\u0000\u0379\u037b\u0005T\u0000\u0000\u037a\u0379\u0001\u0000\u0000\u0000"+
		"\u037a\u037b\u0001\u0000\u0000\u0000\u037b\u0381\u0001\u0000\u0000\u0000"+
		"\u037c\u037e\u0003z=\u0000\u037d\u037f\u0005T\u0000\u0000\u037e\u037d"+
		"\u0001\u0000\u0000\u0000\u037e\u037f\u0001\u0000\u0000\u0000\u037f\u0381"+
		"\u0001\u0000\u0000\u0000\u0380\u036c\u0001\u0000\u0000\u0000\u0380\u0370"+
		"\u0001\u0000\u0000\u0000\u0380\u0374\u0001\u0000\u0000\u0000\u0380\u0378"+
		"\u0001\u0000\u0000\u0000\u0380\u037c\u0001\u0000\u0000\u0000\u0381\u0081"+
		"\u0001\u0000\u0000\u0000\u0382\u0385\u0003\u0084B\u0000\u0383\u0385\u0003"+
		"\u0086C\u0000\u0384\u0382\u0001\u0000\u0000\u0000\u0384\u0383\u0001\u0000"+
		"\u0000\u0000\u0385\u0083\u0001\u0000\u0000\u0000\u0386\u0387\u0003\u0098"+
		"L\u0000\u0387\u0388\u0005N\u0000\u0000\u0388\u038a\u0005O\u0000\u0000"+
		"\u0389\u038b\u0003\u0088D\u0000\u038a\u0389\u0001\u0000\u0000\u0000\u038a"+
		"\u038b\u0001\u0000\u0000\u0000\u038b\u0085\u0001\u0000\u0000\u0000\u038c"+
		"\u038d\u0003H$\u0000\u038d\u0087\u0001\u0000\u0000\u0000\u038e\u038f\u0005"+
		"\f\u0000\u0000\u038f\u0390\u0003v;\u0000\u0390\u0089\u0001\u0000\u0000"+
		"\u0000\u0391\u0393\u00054\u0000\u0000\u0392\u0391\u0001\u0000\u0000\u0000"+
		"\u0392\u0393\u0001\u0000\u0000\u0000\u0393\u0394\u0001\u0000\u0000\u0000"+
		"\u0394\u0395\u00053\u0000\u0000\u0395\u0396\u0003f3\u0000\u0396\u0397"+
		"\u0003\u008cF\u0000\u0397\u008b\u0001\u0000\u0000\u0000\u0398\u039c\u0005"+
		"P\u0000\u0000\u0399\u039b\u0003\u008eG\u0000\u039a\u0399\u0001\u0000\u0000"+
		"\u0000\u039b\u039e\u0001\u0000\u0000\u0000\u039c\u039a\u0001\u0000\u0000"+
		"\u0000\u039c\u039d\u0001\u0000\u0000\u0000\u039d\u039f\u0001\u0000\u0000"+
		"\u0000\u039e\u039c\u0001\u0000\u0000\u0000\u039f\u03a0\u0005Q\u0000\u0000"+
		"\u03a0\u008d\u0001\u0000\u0000\u0000\u03a1\u03a5\u00055\u0000\u0000\u03a2"+
		"\u03a4\u0003\u0090H\u0000\u03a3\u03a2\u0001\u0000\u0000\u0000\u03a4\u03a7"+
		"\u0001\u0000\u0000\u0000\u03a5\u03a3\u0001\u0000\u0000\u0000\u03a5\u03a6"+
		"\u0001\u0000\u0000\u0000\u03a6\u03a8\u0001\u0000\u0000\u0000\u03a7\u03a5"+
		"\u0001\u0000\u0000\u0000\u03a8\u03a9\u0003f3\u0000\u03a9\u03aa\u0005T"+
		"\u0000\u0000\u03aa\u03c6\u0001\u0000\u0000\u0000\u03ab\u03ac\u00056\u0000"+
		"\u0000\u03ac\u03af\u0003f3\u0000\u03ad\u03ae\u00058\u0000\u0000\u03ae"+
		"\u03b0\u0003f3\u0000\u03af\u03ad\u0001\u0000\u0000\u0000\u03af\u03b0\u0001"+
		"\u0000\u0000\u0000\u03b0\u03b1\u0001\u0000\u0000\u0000\u03b1\u03b2\u0005"+
		"T\u0000\u0000\u03b2\u03c6\u0001\u0000\u0000\u0000\u03b3\u03b4\u00057\u0000"+
		"\u0000\u03b4\u03b7\u0003f3\u0000\u03b5\u03b6\u00058\u0000\u0000\u03b6"+
		"\u03b8\u0003f3\u0000\u03b7\u03b5\u0001\u0000\u0000\u0000\u03b7\u03b8\u0001"+
		"\u0000\u0000\u0000\u03b8\u03b9\u0001\u0000\u0000\u0000\u03b9\u03ba\u0005"+
		"T\u0000\u0000\u03ba\u03c6\u0001\u0000\u0000\u0000\u03bb\u03bc\u00059\u0000"+
		"\u0000\u03bc\u03bd\u0003f3\u0000\u03bd\u03be\u0005T\u0000\u0000\u03be"+
		"\u03c6\u0001\u0000\u0000\u0000\u03bf\u03c0\u0005:\u0000\u0000\u03c0\u03c1"+
		"\u0003f3\u0000\u03c1\u03c2\u0005;\u0000\u0000\u03c2\u03c3\u0003f3\u0000"+
		"\u03c3\u03c4\u0005T\u0000\u0000\u03c4\u03c6\u0001\u0000\u0000\u0000\u03c5"+
		"\u03a1\u0001\u0000\u0000\u0000\u03c5\u03ab\u0001\u0000\u0000\u0000\u03c5"+
		"\u03b3\u0001\u0000\u0000\u0000\u03c5\u03bb\u0001\u0000\u0000\u0000\u03c5"+
		"\u03bf\u0001\u0000\u0000\u0000\u03c6\u008f\u0001\u0000\u0000\u0000\u03c7"+
		"\u03c8\u0007\u0003\u0000\u0000\u03c8\u0091\u0001\u0000\u0000\u0000\u03c9"+
		"\u03cd\u0005P\u0000\u0000\u03ca\u03cc\u0003\u0094J\u0000\u03cb\u03ca\u0001"+
		"\u0000\u0000\u0000\u03cc\u03cf\u0001\u0000\u0000\u0000\u03cd\u03cb\u0001"+
		"\u0000\u0000\u0000\u03cd\u03ce\u0001\u0000\u0000\u0000\u03ce\u03d0\u0001"+
		"\u0000\u0000\u0000\u03cf\u03cd\u0001\u0000\u0000\u0000\u03d0\u03d1\u0005"+
		"Q\u0000\u0000\u03d1\u0093\u0001\u0000\u0000\u0000\u03d2\u03d3\u0003\u0096"+
		"K\u0000\u03d3\u03d4\u0005T\u0000\u0000\u03d4\u03d8\u0001\u0000\u0000\u0000"+
		"\u03d5\u03d8\u0003\u009cN\u0000\u03d6\u03d8\u0003\u009eO\u0000\u03d7\u03d2"+
		"\u0001\u0000\u0000\u0000\u03d7\u03d5\u0001\u0000\u0000\u0000\u03d7\u03d6"+
		"\u0001\u0000\u0000\u0000\u03d8\u0095\u0001\u0000\u0000\u0000\u03d9\u03db"+
		"\u0003\f\u0006\u0000\u03da\u03d9\u0001\u0000\u0000\u0000\u03db\u03de\u0001"+
		"\u0000\u0000\u0000\u03dc\u03da\u0001\u0000\u0000\u0000\u03dc\u03dd\u0001"+
		"\u0000\u0000\u0000\u03dd\u03e7\u0001\u0000\u0000\u0000\u03de\u03dc\u0001"+
		"\u0000\u0000\u0000\u03df\u03e0\u0005=\u0000\u0000\u03e0\u03e1\u0003\u0098"+
		"L\u0000\u03e1\u03e2\u0005W\u0000\u0000\u03e2\u03e3\u0003\u00bc^\u0000"+
		"\u03e3\u03e8\u0001\u0000\u0000\u0000\u03e4\u03e5\u0003\u00e6s\u0000\u03e5"+
		"\u03e6\u0003H$\u0000\u03e6\u03e8\u0001\u0000\u0000\u0000\u03e7\u03df\u0001"+
		"\u0000\u0000\u0000\u03e7\u03e4\u0001\u0000\u0000\u0000\u03e8\u0097\u0001"+
		"\u0000\u0000\u0000\u03e9\u03ea\u0007\u0004\u0000\u0000\u03ea\u0099\u0001"+
		"\u0000\u0000\u0000\u03eb\u03ec\u0007\u0005\u0000\u0000\u03ec\u009b\u0001"+
		"\u0000\u0000\u0000\u03ed\u03ef\u0003\n\u0005\u0000\u03ee\u03ed\u0001\u0000"+
		"\u0000\u0000\u03ef\u03f2\u0001\u0000\u0000\u0000\u03f0\u03ee\u0001\u0000"+
		"\u0000\u0000\u03f0\u03f1\u0001\u0000\u0000\u0000\u03f1\u03f5\u0001\u0000"+
		"\u0000\u0000\u03f2\u03f0\u0001\u0000\u0000\u0000\u03f3\u03f6\u0003\u000e"+
		"\u0007\u0000\u03f4\u03f6\u0003\u001e\u000f\u0000\u03f5\u03f3\u0001\u0000"+
		"\u0000\u0000\u03f5\u03f4\u0001\u0000\u0000\u0000\u03f6\u009d\u0001\u0000"+
		"\u0000\u0000\u03f7\u0469\u0003\u0092I\u0000\u03f8\u03f9\u0005\u0002\u0000"+
		"\u0000\u03f9\u03fc\u0003\u00bc^\u0000\u03fa\u03fb\u0005]\u0000\u0000\u03fb"+
		"\u03fd\u0003\u00bc^\u0000\u03fc\u03fa\u0001\u0000\u0000\u0000\u03fc\u03fd"+
		"\u0001\u0000\u0000\u0000\u03fd\u03fe\u0001\u0000\u0000\u0000\u03fe\u03ff"+
		"\u0005T\u0000\u0000\u03ff\u0469\u0001\u0000\u0000\u0000\u0400\u0401\u0005"+
		"\u0016\u0000\u0000\u0401\u0402\u0003\u00b6[\u0000\u0402\u0405\u0003\u009e"+
		"O\u0000\u0403\u0404\u0005\u000f\u0000\u0000\u0404\u0406\u0003\u009eO\u0000"+
		"\u0405\u0403\u0001\u0000\u0000\u0000\u0405\u0406\u0001\u0000\u0000\u0000"+
		"\u0406\u0469\u0001\u0000\u0000\u0000\u0407\u0408\u0005\u0015\u0000\u0000"+
		"\u0408\u0409\u0005N\u0000\u0000\u0409\u040a\u0003\u00b0X\u0000\u040a\u040b"+
		"\u0005O\u0000\u0000\u040b\u040c\u0003\u009eO\u0000\u040c\u0469\u0001\u0000"+
		"\u0000\u0000\u040d\u040e\u00052\u0000\u0000\u040e\u040f\u0003\u00b6[\u0000"+
		"\u040f\u0410\u0003\u009eO\u0000\u0410\u0469\u0001\u0000\u0000\u0000\u0411"+
		"\u0412\u0005\r\u0000\u0000\u0412\u0413\u0003\u009eO\u0000\u0413\u0414"+
		"\u00052\u0000\u0000\u0414\u0415\u0003\u00b6[\u0000\u0415\u0416\u0005T"+
		"\u0000\u0000\u0416\u0469\u0001\u0000\u0000\u0000\u0417\u0418\u0005/\u0000"+
		"\u0000\u0418\u0422\u0003\u0092I\u0000\u0419\u041b\u0003\u00a0P\u0000\u041a"+
		"\u0419\u0001\u0000\u0000\u0000\u041b\u041c\u0001\u0000\u0000\u0000\u041c"+
		"\u041a\u0001\u0000\u0000\u0000\u041c\u041d\u0001\u0000\u0000\u0000\u041d"+
		"\u041f\u0001\u0000\u0000\u0000\u041e\u0420\u0003\u00a4R\u0000\u041f\u041e"+
		"\u0001\u0000\u0000\u0000\u041f\u0420\u0001\u0000\u0000\u0000\u0420\u0423"+
		"\u0001\u0000\u0000\u0000\u0421\u0423\u0003\u00a4R\u0000\u0422\u041a\u0001"+
		"\u0000\u0000\u0000\u0422\u0421\u0001\u0000\u0000\u0000\u0423\u0469\u0001"+
		"\u0000\u0000\u0000\u0424\u0425\u0005/\u0000\u0000\u0425\u0426\u0003\u00a6"+
		"S\u0000\u0426\u042a\u0003\u0092I\u0000\u0427\u0429\u0003\u00a0P\u0000"+
		"\u0428\u0427\u0001\u0000\u0000\u0000\u0429\u042c\u0001\u0000\u0000\u0000"+
		"\u042a\u0428\u0001\u0000\u0000\u0000\u042a\u042b\u0001\u0000\u0000\u0000"+
		"\u042b\u042e\u0001\u0000\u0000\u0000\u042c\u042a\u0001\u0000\u0000\u0000"+
		"\u042d\u042f\u0003\u00a4R\u0000\u042e\u042d\u0001\u0000\u0000\u0000\u042e"+
		"\u042f\u0001\u0000\u0000\u0000\u042f\u0469\u0001\u0000\u0000\u0000\u0430"+
		"\u0431\u0005)\u0000\u0000\u0431\u0432\u0003\u00b6[\u0000\u0432\u0436\u0005"+
		"P\u0000\u0000\u0433\u0435\u0003\u00acV\u0000\u0434\u0433\u0001\u0000\u0000"+
		"\u0000\u0435\u0438\u0001\u0000\u0000\u0000\u0436\u0434\u0001\u0000\u0000"+
		"\u0000\u0436\u0437\u0001\u0000\u0000\u0000\u0437\u043c\u0001\u0000\u0000"+
		"\u0000\u0438\u0436\u0001\u0000\u0000\u0000\u0439\u043b\u0003\u00aeW\u0000"+
		"\u043a\u0439\u0001\u0000\u0000\u0000\u043b\u043e\u0001\u0000\u0000\u0000"+
		"\u043c\u043a\u0001\u0000\u0000\u0000\u043c\u043d\u0001\u0000\u0000\u0000"+
		"\u043d\u043f\u0001\u0000\u0000\u0000\u043e\u043c\u0001\u0000\u0000\u0000"+
		"\u043f\u0440\u0005Q\u0000\u0000\u0440\u0469\u0001\u0000\u0000\u0000\u0441"+
		"\u0442\u0005*\u0000\u0000\u0442\u0443\u0003\u00b6[\u0000\u0443\u0444\u0003"+
		"\u0092I\u0000\u0444\u0469\u0001\u0000\u0000\u0000\u0445\u0447\u0005$\u0000"+
		"\u0000\u0446\u0448\u0003\u00bc^\u0000\u0447\u0446\u0001\u0000\u0000\u0000"+
		"\u0447\u0448\u0001\u0000\u0000\u0000\u0448\u0449\u0001\u0000\u0000\u0000"+
		"\u0449\u0469\u0005T\u0000\u0000\u044a\u044b\u0005,\u0000\u0000\u044b\u044c"+
		"\u0003\u00bc^\u0000\u044c\u044d\u0005T\u0000\u0000\u044d\u0469\u0001\u0000"+
		"\u0000\u0000\u044e\u0450\u0005\u0004\u0000\u0000\u044f\u0451\u0003\u0098"+
		"L\u0000\u0450\u044f\u0001\u0000\u0000\u0000\u0450\u0451\u0001\u0000\u0000"+
		"\u0000\u0451\u0452\u0001\u0000\u0000\u0000\u0452\u0469\u0005T\u0000\u0000"+
		"\u0453\u0455\u0005\u000b\u0000\u0000\u0454\u0456\u0003\u0098L\u0000\u0455"+
		"\u0454\u0001\u0000\u0000\u0000\u0455\u0456\u0001\u0000\u0000\u0000\u0456"+
		"\u0457\u0001\u0000\u0000\u0000\u0457\u0469\u0005T\u0000\u0000\u0458\u0459"+
		"\u0005>\u0000\u0000\u0459\u045a\u0003\u00bc^\u0000\u045a\u045b\u0005T"+
		"\u0000\u0000\u045b\u0469\u0001\u0000\u0000\u0000\u045c\u0469\u0005T\u0000"+
		"\u0000\u045d\u045e\u0003\u00bc^\u0000\u045e\u045f\u0005T\u0000\u0000\u045f"+
		"\u0469\u0001\u0000\u0000\u0000\u0460\u0462\u0003\u00c8d\u0000\u0461\u0463"+
		"\u0005T\u0000\u0000\u0462\u0461\u0001\u0000\u0000\u0000\u0462\u0463\u0001"+
		"\u0000\u0000\u0000\u0463\u0469\u0001\u0000\u0000\u0000\u0464\u0465\u0003"+
		"\u0098L\u0000\u0465\u0466\u0005]\u0000\u0000\u0466\u0467\u0003\u009eO"+
		"\u0000\u0467\u0469\u0001\u0000\u0000\u0000\u0468\u03f7\u0001\u0000\u0000"+
		"\u0000\u0468\u03f8\u0001\u0000\u0000\u0000\u0468\u0400\u0001\u0000\u0000"+
		"\u0000\u0468\u0407\u0001\u0000\u0000\u0000\u0468\u040d\u0001\u0000\u0000"+
		"\u0000\u0468\u0411\u0001\u0000\u0000\u0000\u0468\u0417\u0001\u0000\u0000"+
		"\u0000\u0468\u0424\u0001\u0000\u0000\u0000\u0468\u0430\u0001\u0000\u0000"+
		"\u0000\u0468\u0441\u0001\u0000\u0000\u0000\u0468\u0445\u0001\u0000\u0000"+
		"\u0000\u0468\u044a\u0001\u0000\u0000\u0000\u0468\u044e\u0001\u0000\u0000"+
		"\u0000\u0468\u0453\u0001\u0000\u0000\u0000\u0468\u0458\u0001\u0000\u0000"+
		"\u0000\u0468\u045c\u0001\u0000\u0000\u0000\u0468\u045d\u0001\u0000\u0000"+
		"\u0000\u0468\u0460\u0001\u0000\u0000\u0000\u0468\u0464\u0001\u0000\u0000"+
		"\u0000\u0469\u009f\u0001\u0000\u0000\u0000\u046a\u046b\u0005\u0007\u0000"+
		"\u0000\u046b\u046f\u0005N\u0000\u0000\u046c\u046e\u0003\f\u0006\u0000"+
		"\u046d\u046c\u0001\u0000\u0000\u0000\u046e\u0471\u0001\u0000\u0000\u0000"+
		"\u046f\u046d\u0001\u0000\u0000\u0000\u046f\u0470\u0001\u0000\u0000\u0000"+
		"\u0470\u0472\u0001\u0000\u0000\u0000\u0471\u046f\u0001\u0000\u0000\u0000"+
		"\u0472\u0473\u0003\u00a2Q\u0000\u0473\u0474\u0003\u0098L\u0000\u0474\u0475"+
		"\u0005O\u0000\u0000\u0475\u0476\u0003\u0092I\u0000\u0476\u00a1\u0001\u0000"+
		"\u0000\u0000\u0477\u047c\u0003f3\u0000\u0478\u0479\u0005k\u0000\u0000"+
		"\u0479\u047b\u0003f3\u0000\u047a\u0478\u0001\u0000\u0000\u0000\u047b\u047e"+
		"\u0001\u0000\u0000\u0000\u047c\u047a\u0001\u0000\u0000\u0000\u047c\u047d"+
		"\u0001\u0000\u0000\u0000\u047d\u00a3\u0001\u0000\u0000\u0000\u047e\u047c"+
		"\u0001\u0000\u0000\u0000\u047f\u0480\u0005\u0013\u0000\u0000\u0480\u0481"+
		"\u0003\u0092I\u0000\u0481\u00a5\u0001\u0000\u0000\u0000\u0482\u0483\u0005"+
		"N\u0000\u0000\u0483\u0485\u0003\u00a8T\u0000\u0484\u0486\u0005T\u0000"+
		"\u0000\u0485\u0484\u0001\u0000\u0000\u0000\u0485\u0486\u0001\u0000\u0000"+
		"\u0000\u0486\u0487\u0001\u0000\u0000\u0000\u0487\u0488\u0005O\u0000\u0000"+
		"\u0488\u00a7\u0001\u0000\u0000\u0000\u0489\u048e\u0003\u00aaU\u0000\u048a"+
		"\u048b\u0005T\u0000\u0000\u048b\u048d\u0003\u00aaU\u0000\u048c\u048a\u0001"+
		"\u0000\u0000\u0000\u048d\u0490\u0001\u0000\u0000\u0000\u048e\u048c\u0001"+
		"\u0000\u0000\u0000\u048e\u048f\u0001\u0000\u0000\u0000\u048f\u00a9\u0001"+
		"\u0000\u0000\u0000\u0490\u048e\u0001\u0000\u0000\u0000\u0491\u0493\u0003"+
		"\f\u0006\u0000\u0492\u0491\u0001\u0000\u0000\u0000\u0493\u0496\u0001\u0000"+
		"\u0000\u0000\u0494\u0492\u0001\u0000\u0000\u0000\u0494\u0495\u0001\u0000"+
		"\u0000\u0000\u0495\u049c\u0001\u0000\u0000\u0000\u0496\u0494\u0001\u0000"+
		"\u0000\u0000\u0497\u0498\u0003R)\u0000\u0498\u0499\u0003L&\u0000\u0499"+
		"\u049d\u0001\u0000\u0000\u0000\u049a\u049b\u0005=\u0000\u0000\u049b\u049d"+
		"\u0003\u0098L\u0000\u049c\u0497\u0001\u0000\u0000\u0000\u049c\u049a\u0001"+
		"\u0000\u0000\u0000\u049d\u049e\u0001\u0000\u0000\u0000\u049e\u049f\u0005"+
		"W\u0000\u0000\u049f\u04a0\u0003\u00bc^\u0000\u04a0\u04a3\u0001\u0000\u0000"+
		"\u0000\u04a1\u04a3\u0003f3\u0000\u04a2\u0494\u0001\u0000\u0000\u0000\u04a2"+
		"\u04a1\u0001\u0000\u0000\u0000\u04a3\u00ab\u0001\u0000\u0000\u0000\u04a4"+
		"\u04a6\u0003\u00aeW\u0000\u04a5\u04a4\u0001\u0000\u0000\u0000\u04a6\u04a7"+
		"\u0001\u0000\u0000\u0000\u04a7\u04a5\u0001\u0000\u0000\u0000\u04a7\u04a8"+
		"\u0001\u0000\u0000\u0000\u04a8\u04aa\u0001\u0000\u0000\u0000\u04a9\u04ab"+
		"\u0003\u0094J\u0000\u04aa\u04a9\u0001\u0000\u0000\u0000\u04ab\u04ac\u0001"+
		"\u0000\u0000\u0000\u04ac\u04aa\u0001\u0000\u0000\u0000\u04ac\u04ad\u0001"+
		"\u0000\u0000\u0000\u04ad\u00ad\u0001\u0000\u0000\u0000\u04ae\u04b4\u0005"+
		"\u0006\u0000\u0000\u04af\u04b5\u0003\u00bc^\u0000\u04b0\u04b5\u0005\u0082"+
		"\u0000\u0000\u04b1\u04b2\u0003\u00e6s\u0000\u04b2\u04b3\u0003\u0098L\u0000"+
		"\u04b3\u04b5\u0001\u0000\u0000\u0000\u04b4\u04af\u0001\u0000\u0000\u0000"+
		"\u04b4\u04b0\u0001\u0000\u0000\u0000\u04b4\u04b1\u0001\u0000\u0000\u0000"+
		"\u04b5\u04b6\u0001\u0000\u0000\u0000\u04b6\u04ba\u0005]\u0000\u0000\u04b7"+
		"\u04b8\u0005\f\u0000\u0000\u04b8\u04ba\u0005]\u0000\u0000\u04b9\u04ae"+
		"\u0001\u0000\u0000\u0000\u04b9\u04b7\u0001\u0000\u0000\u0000\u04ba\u00af"+
		"\u0001\u0000\u0000\u0000\u04bb\u04c8\u0003\u00b4Z\u0000\u04bc\u04be\u0003"+
		"\u00b2Y\u0000\u04bd\u04bc\u0001\u0000\u0000\u0000\u04bd\u04be\u0001\u0000"+
		"\u0000\u0000\u04be\u04bf\u0001\u0000\u0000\u0000\u04bf\u04c1\u0005T\u0000"+
		"\u0000\u04c0\u04c2\u0003\u00bc^\u0000\u04c1\u04c0\u0001\u0000\u0000\u0000"+
		"\u04c1\u04c2\u0001\u0000\u0000\u0000\u04c2\u04c3\u0001\u0000\u0000\u0000"+
		"\u04c3\u04c5\u0005T\u0000\u0000\u04c4\u04c6\u0003\u00b8\\\u0000\u04c5"+
		"\u04c4\u0001\u0000\u0000\u0000\u04c5\u04c6\u0001\u0000\u0000\u0000\u04c6"+
		"\u04c8\u0001\u0000\u0000\u0000\u04c7\u04bb\u0001\u0000\u0000\u0000\u04c7"+
		"\u04bd\u0001\u0000\u0000\u0000\u04c8\u00b1\u0001\u0000\u0000\u0000\u04c9"+
		"\u04cc\u0003\u0096K\u0000\u04ca\u04cc\u0003\u00b8\\\u0000\u04cb\u04c9"+
		"\u0001\u0000\u0000\u0000\u04cb\u04ca\u0001\u0000\u0000\u0000\u04cc\u00b3"+
		"\u0001\u0000\u0000\u0000\u04cd\u04cf\u0003\f\u0006\u0000\u04ce\u04cd\u0001"+
		"\u0000\u0000\u0000\u04cf\u04d2\u0001\u0000\u0000\u0000\u04d0\u04ce\u0001"+
		"\u0000\u0000\u0000\u04d0\u04d1\u0001\u0000\u0000\u0000\u04d1\u04d5\u0001"+
		"\u0000\u0000\u0000\u04d2\u04d0\u0001\u0000\u0000\u0000\u04d3\u04d6\u0003"+
		"\u00e6s\u0000\u04d4\u04d6\u0005=\u0000\u0000\u04d5\u04d3\u0001\u0000\u0000"+
		"\u0000\u04d5\u04d4\u0001\u0000\u0000\u0000\u04d6\u04d7\u0001\u0000\u0000"+
		"\u0000\u04d7\u04d8\u0003L&\u0000\u04d8\u04d9\u0005]\u0000\u0000\u04d9"+
		"\u04da\u0003\u00bc^\u0000\u04da\u00b5\u0001\u0000\u0000\u0000\u04db\u04dc"+
		"\u0005N\u0000\u0000\u04dc\u04dd\u0003\u00bc^\u0000\u04dd\u04de\u0005O"+
		"\u0000\u0000\u04de\u00b7\u0001\u0000\u0000\u0000\u04df\u04e4\u0003\u00bc"+
		"^\u0000\u04e0\u04e1\u0005U\u0000\u0000\u04e1\u04e3\u0003\u00bc^\u0000"+
		"\u04e2\u04e0\u0001\u0000\u0000\u0000\u04e3\u04e6\u0001\u0000\u0000\u0000"+
		"\u04e4\u04e2\u0001\u0000\u0000\u0000\u04e4\u04e5\u0001\u0000\u0000\u0000"+
		"\u04e5\u00b9\u0001\u0000\u0000\u0000\u04e6\u04e4\u0001\u0000\u0000\u0000"+
		"\u04e7\u04eb\u0003\u0098L\u0000\u04e8\u04eb\u0005+\u0000\u0000\u04e9\u04eb"+
		"\u0005(\u0000\u0000\u04ea\u04e7\u0001\u0000\u0000\u0000\u04ea\u04e8\u0001"+
		"\u0000\u0000\u0000\u04ea\u04e9\u0001\u0000\u0000\u0000\u04eb\u04ec\u0001"+
		"\u0000\u0000\u0000\u04ec\u04ed\u0003\u00f0x\u0000\u04ed\u00bb\u0001\u0000"+
		"\u0000\u0000\u04ee\u04ef\u0006^\uffff\uffff\u0000\u04ef\u051a\u0003\u00c6"+
		"c\u0000\u04f0\u051a\u0003\u00ba]\u0000\u04f1\u04f2\u0003\u00e6s\u0000"+
		"\u04f2\u04f8\u0005z\u0000\u0000\u04f3\u04f5\u0003\u00eau\u0000\u04f4\u04f3"+
		"\u0001\u0000\u0000\u0000\u04f4\u04f5\u0001\u0000\u0000\u0000\u04f5\u04f6"+
		"\u0001\u0000\u0000\u0000\u04f6\u04f9\u0003\u0098L\u0000\u04f7\u04f9\u0005"+
		"\u001f\u0000\u0000\u04f8\u04f4\u0001\u0000\u0000\u0000\u04f8\u04f7\u0001"+
		"\u0000\u0000\u0000\u04f9\u051a\u0001\u0000\u0000\u0000\u04fa\u04fb\u0003"+
		"\u00d0h\u0000\u04fb\u04fd\u0005z\u0000\u0000\u04fc\u04fe\u0003\u00eau"+
		"\u0000\u04fd\u04fc\u0001\u0000\u0000\u0000\u04fd\u04fe\u0001\u0000\u0000"+
		"\u0000\u04fe\u04ff\u0001\u0000\u0000\u0000\u04ff\u0500\u0005\u001f\u0000"+
		"\u0000\u0500\u051a\u0001\u0000\u0000\u0000\u0501\u051a\u0003\u00c8d\u0000"+
		"\u0502\u0503\u0007\u0006\u0000\u0000\u0503\u051a\u0003\u00bc^\u0011\u0504"+
		"\u0508\u0005N\u0000\u0000\u0505\u0507\u0003p8\u0000\u0506\u0505\u0001"+
		"\u0000\u0000\u0000\u0507\u050a\u0001\u0000\u0000\u0000\u0508\u0506\u0001"+
		"\u0000\u0000\u0000\u0508\u0509\u0001\u0000\u0000\u0000\u0509\u050b\u0001"+
		"\u0000\u0000\u0000\u050a\u0508\u0001\u0000\u0000\u0000\u050b\u0510\u0003"+
		"\u00e6s\u0000\u050c\u050d\u0005j\u0000\u0000\u050d\u050f\u0003\u00e6s"+
		"\u0000\u050e\u050c\u0001\u0000\u0000\u0000\u050f\u0512\u0001\u0000\u0000"+
		"\u0000\u0510\u050e\u0001\u0000\u0000\u0000\u0510\u0511\u0001\u0000\u0000"+
		"\u0000\u0511\u0513\u0001\u0000\u0000\u0000\u0512\u0510\u0001\u0000\u0000"+
		"\u0000\u0513\u0514\u0005O\u0000\u0000\u0514\u0515\u0003\u00bc^\u0010\u0515"+
		"\u051a\u0001\u0000\u0000\u0000\u0516\u0517\u0005\u001f\u0000\u0000\u0517"+
		"\u051a\u0003\u00d2i\u0000\u0518\u051a\u0003\u00c0`\u0000\u0519\u04ee\u0001"+
		"\u0000\u0000\u0000\u0519\u04f0\u0001\u0000\u0000\u0000\u0519\u04f1\u0001"+
		"\u0000\u0000\u0000\u0519\u04fa\u0001\u0000\u0000\u0000\u0519\u0501\u0001"+
		"\u0000\u0000\u0000\u0519\u0502\u0001\u0000\u0000\u0000\u0519\u0504\u0001"+
		"\u0000\u0000\u0000\u0519\u0516\u0001\u0000\u0000\u0000\u0519\u0518\u0001"+
		"\u0000\u0000\u0000\u051a\u056e\u0001\u0000\u0000\u0000\u051b\u051c\n\u000e"+
		"\u0000\u0000\u051c\u051d\u0007\u0007\u0000\u0000\u051d\u056d\u0003\u00bc"+
		"^\u000f\u051e\u051f\n\r\u0000\u0000\u051f\u0520\u0007\b\u0000\u0000\u0520"+
		"\u056d\u0003\u00bc^\u000e\u0521\u0529\n\f\u0000\u0000\u0522\u0523\u0005"+
		"Y\u0000\u0000\u0523\u052a\u0005Y\u0000\u0000\u0524\u0525\u0005X\u0000"+
		"\u0000\u0525\u0526\u0005X\u0000\u0000\u0526\u052a\u0005X\u0000\u0000\u0527"+
		"\u0528\u0005X\u0000\u0000\u0528\u052a\u0005X\u0000\u0000\u0529\u0522\u0001"+
		"\u0000\u0000\u0000\u0529\u0524\u0001\u0000\u0000\u0000\u0529\u0527\u0001"+
		"\u0000\u0000\u0000\u052a\u052b\u0001\u0000\u0000\u0000\u052b\u056d\u0003"+
		"\u00bc^\r\u052c\u052d\n\u000b\u0000\u0000\u052d\u052e\u0007\t\u0000\u0000"+
		"\u052e\u056d\u0003\u00bc^\f\u052f\u0530\n\t\u0000\u0000\u0530\u0531\u0007"+
		"\n\u0000\u0000\u0531\u056d\u0003\u00bc^\n\u0532\u0533\n\b\u0000\u0000"+
		"\u0533\u0534\u0005j\u0000\u0000\u0534\u056d\u0003\u00bc^\t\u0535\u0536"+
		"\n\u0007\u0000\u0000\u0536\u0537\u0005l\u0000\u0000\u0537\u056d\u0003"+
		"\u00bc^\b\u0538\u0539\n\u0006\u0000\u0000\u0539\u053a\u0005k\u0000\u0000"+
		"\u053a\u056d\u0003\u00bc^\u0007\u053b\u053c\n\u0005\u0000\u0000\u053c"+
		"\u053d\u0005b\u0000\u0000\u053d\u056d\u0003\u00bc^\u0006\u053e\u053f\n"+
		"\u0004\u0000\u0000\u053f\u0540\u0005c\u0000\u0000\u0540\u056d\u0003\u00bc"+
		"^\u0005\u0541\u0542\n\u0003\u0000\u0000\u0542\u0543\u0005\\\u0000\u0000"+
		"\u0543\u0544\u0003\u00bc^\u0000\u0544\u0545\u0005]\u0000\u0000\u0545\u0546"+
		"\u0003\u00bc^\u0003\u0546\u056d\u0001\u0000\u0000\u0000\u0547\u0548\n"+
		"\u0002\u0000\u0000\u0548\u0549\u0007\u000b\u0000\u0000\u0549\u056d\u0003"+
		"\u00bc^\u0002\u054a\u054b\n\u0019\u0000\u0000\u054b\u054c\u0005R\u0000"+
		"\u0000\u054c\u054d\u0003\u00bc^\u0000\u054d\u054e\u0005S\u0000\u0000\u054e"+
		"\u056d\u0001\u0000\u0000\u0000\u054f\u0550\n\u0018\u0000\u0000\u0550\u055c"+
		"\u0005V\u0000\u0000\u0551\u055d\u0003\u0098L\u0000\u0552\u055d\u0003\u00ba"+
		"]\u0000\u0553\u055d\u0005+\u0000\u0000\u0554\u0556\u0005\u001f\u0000\u0000"+
		"\u0555\u0557\u0003\u00e2q\u0000\u0556\u0555\u0001\u0000\u0000\u0000\u0556"+
		"\u0557\u0001\u0000\u0000\u0000\u0557\u0558\u0001\u0000\u0000\u0000\u0558"+
		"\u055d\u0003\u00d6k\u0000\u0559\u055a\u0005(\u0000\u0000\u055a\u055d\u0003"+
		"\u00ecv\u0000\u055b\u055d\u0003\u00dcn\u0000\u055c\u0551\u0001\u0000\u0000"+
		"\u0000\u055c\u0552\u0001\u0000\u0000\u0000\u055c\u0553\u0001\u0000\u0000"+
		"\u0000\u055c\u0554\u0001\u0000\u0000\u0000\u055c\u0559\u0001\u0000\u0000"+
		"\u0000\u055c\u055b\u0001\u0000\u0000\u0000\u055d\u056d\u0001\u0000\u0000"+
		"\u0000\u055e\u055f\n\u0016\u0000\u0000\u055f\u0561\u0005z\u0000\u0000"+
		"\u0560\u0562\u0003\u00eau\u0000\u0561\u0560\u0001\u0000\u0000\u0000\u0561"+
		"\u0562\u0001\u0000\u0000\u0000\u0562\u0563\u0001\u0000\u0000\u0000\u0563"+
		"\u056d\u0003\u0098L\u0000\u0564\u0565\n\u0012\u0000\u0000\u0565\u056d"+
		"\u0007\f\u0000\u0000\u0566\u0567\n\n\u0000\u0000\u0567\u056a\u0005\u001a"+
		"\u0000\u0000\u0568\u056b\u0003\u00e6s\u0000\u0569\u056b\u0003\u00be_\u0000"+
		"\u056a\u0568\u0001\u0000\u0000\u0000\u056a\u0569\u0001\u0000\u0000\u0000"+
		"\u056b\u056d\u0001\u0000\u0000\u0000\u056c\u051b\u0001\u0000\u0000\u0000"+
		"\u056c\u051e\u0001\u0000\u0000\u0000\u056c\u0521\u0001\u0000\u0000\u0000"+
		"\u056c\u052c\u0001\u0000\u0000\u0000\u056c\u052f\u0001\u0000\u0000\u0000"+
		"\u056c\u0532\u0001\u0000\u0000\u0000\u056c\u0535\u0001\u0000\u0000\u0000"+
		"\u056c\u0538\u0001\u0000\u0000\u0000\u056c\u053b\u0001\u0000\u0000\u0000"+
		"\u056c\u053e\u0001\u0000\u0000\u0000\u056c\u0541\u0001\u0000\u0000\u0000"+
		"\u056c\u0547\u0001\u0000\u0000\u0000\u056c\u054a\u0001\u0000\u0000\u0000"+
		"\u056c\u054f\u0001\u0000\u0000\u0000\u056c\u055e\u0001\u0000\u0000\u0000"+
		"\u056c\u0564\u0001\u0000\u0000\u0000\u056c\u0566\u0001\u0000\u0000\u0000"+
		"\u056d\u0570\u0001\u0000\u0000\u0000\u056e\u056c\u0001\u0000\u0000\u0000"+
		"\u056e\u056f\u0001\u0000\u0000\u0000\u056f\u00bd\u0001\u0000\u0000\u0000"+
		"\u0570\u056e\u0001\u0000\u0000\u0000\u0571\u0573\u0003\f\u0006\u0000\u0572"+
		"\u0571\u0001\u0000\u0000\u0000\u0573\u0576\u0001\u0000\u0000\u0000\u0574"+
		"\u0572\u0001\u0000\u0000\u0000\u0574\u0575\u0001\u0000\u0000\u0000\u0575"+
		"\u0577\u0001\u0000\u0000\u0000\u0576\u0574\u0001\u0000\u0000\u0000\u0577"+
		"\u057b\u0003\u00e6s\u0000\u0578\u057a\u0003p8\u0000\u0579\u0578\u0001"+
		"\u0000\u0000\u0000\u057a\u057d\u0001\u0000\u0000\u0000\u057b\u0579\u0001"+
		"\u0000\u0000\u0000\u057b\u057c\u0001\u0000\u0000\u0000\u057c\u057e\u0001"+
		"\u0000\u0000\u0000\u057d\u057b\u0001\u0000\u0000\u0000\u057e\u057f\u0003"+
		"\u0098L\u0000\u057f\u00bf\u0001\u0000\u0000\u0000\u0580\u0581\u0003\u00c2"+
		"a\u0000\u0581\u0582\u0005y\u0000\u0000\u0582\u0583\u0003\u00c4b\u0000"+
		"\u0583\u00c1\u0001\u0000\u0000\u0000\u0584\u059b\u0003\u0098L\u0000\u0585"+
		"\u0587\u0005N\u0000\u0000\u0586\u0588\u0003\\.\u0000\u0587\u0586\u0001"+
		"\u0000\u0000\u0000\u0587\u0588\u0001\u0000\u0000\u0000\u0588\u0589\u0001"+
		"\u0000\u0000\u0000\u0589\u059b\u0005O\u0000\u0000\u058a\u058b\u0005N\u0000"+
		"\u0000\u058b\u0590\u0003\u0098L\u0000\u058c\u058d\u0005U\u0000\u0000\u058d"+
		"\u058f\u0003\u0098L\u0000\u058e\u058c\u0001\u0000\u0000\u0000\u058f\u0592"+
		"\u0001\u0000\u0000\u0000\u0590\u058e\u0001\u0000\u0000\u0000\u0590\u0591"+
		"\u0001\u0000\u0000\u0000\u0591\u0593\u0001\u0000\u0000\u0000\u0592\u0590"+
		"\u0001\u0000\u0000\u0000\u0593\u0594\u0005O\u0000\u0000\u0594\u059b\u0001"+
		"\u0000\u0000\u0000\u0595\u0597\u0005N\u0000\u0000\u0596\u0598\u0003b1"+
		"\u0000\u0597\u0596\u0001\u0000\u0000\u0000\u0597\u0598\u0001\u0000\u0000"+
		"\u0000\u0598\u0599\u0001\u0000\u0000\u0000\u0599\u059b\u0005O\u0000\u0000"+
		"\u059a\u0584\u0001\u0000\u0000\u0000\u059a\u0585\u0001\u0000\u0000\u0000"+
		"\u059a\u058a\u0001\u0000\u0000\u0000\u059a\u0595\u0001\u0000\u0000\u0000"+
		"\u059b\u00c3\u0001\u0000\u0000\u0000\u059c\u059f\u0003\u00bc^\u0000\u059d"+
		"\u059f\u0003\u0092I\u0000\u059e\u059c\u0001\u0000\u0000\u0000\u059e\u059d"+
		"\u0001\u0000\u0000\u0000\u059f\u00c5\u0001\u0000\u0000\u0000\u05a0\u05a1"+
		"\u0005N\u0000\u0000\u05a1\u05a2\u0003\u00bc^\u0000\u05a2\u05a3\u0005O"+
		"\u0000\u0000\u05a3\u05b3\u0001\u0000\u0000\u0000\u05a4\u05b3\u0005+\u0000"+
		"\u0000\u05a5\u05b3\u0005(\u0000\u0000\u05a6\u05b3\u0003h4\u0000\u05a7"+
		"\u05b3\u0003\u0098L\u0000\u05a8\u05a9\u0003,\u0016\u0000\u05a9\u05aa\u0005"+
		"V\u0000\u0000\u05aa\u05ab\u0005\t\u0000\u0000\u05ab\u05b3\u0001\u0000"+
		"\u0000\u0000\u05ac\u05b0\u0003\u00e2q\u0000\u05ad\u05b1\u0003\u00eew\u0000"+
		"\u05ae\u05af\u0005+\u0000\u0000\u05af\u05b1\u0003\u00f0x\u0000\u05b0\u05ad"+
		"\u0001\u0000\u0000\u0000\u05b0\u05ae\u0001\u0000\u0000\u0000\u05b1\u05b3"+
		"\u0001\u0000\u0000\u0000\u05b2\u05a0\u0001\u0000\u0000\u0000\u05b2\u05a4"+
		"\u0001\u0000\u0000\u0000\u05b2\u05a5\u0001\u0000\u0000\u0000\u05b2\u05a6"+
		"\u0001\u0000\u0000\u0000\u05b2\u05a7\u0001\u0000\u0000\u0000\u05b2\u05a8"+
		"\u0001\u0000\u0000\u0000\u05b2\u05ac\u0001\u0000\u0000\u0000\u05b3\u00c7"+
		"\u0001\u0000\u0000\u0000\u05b4\u05b5\u0005)\u0000\u0000\u05b5\u05b6\u0003"+
		"\u00b6[\u0000\u05b6\u05ba\u0005P\u0000\u0000\u05b7\u05b9\u0003\u00cae"+
		"\u0000\u05b8\u05b7\u0001\u0000\u0000\u0000\u05b9\u05bc\u0001\u0000\u0000"+
		"\u0000\u05ba\u05b8\u0001\u0000\u0000\u0000\u05ba\u05bb\u0001\u0000\u0000"+
		"\u0000\u05bb\u05bd\u0001\u0000\u0000\u0000\u05bc\u05ba\u0001\u0000\u0000"+
		"\u0000\u05bd\u05be\u0005Q\u0000\u0000\u05be\u00c9\u0001\u0000\u0000\u0000"+
		"\u05bf\u05c3\u0005\u0006\u0000\u0000\u05c0\u05c4\u0003\u00b8\\\u0000\u05c1"+
		"\u05c4\u0005M\u0000\u0000\u05c2\u05c4\u0003\u00ccf\u0000\u05c3\u05c0\u0001"+
		"\u0000\u0000\u0000\u05c3\u05c1\u0001\u0000\u0000\u0000\u05c3\u05c2\u0001"+
		"\u0000\u0000\u0000\u05c4\u05c5\u0001\u0000\u0000\u0000\u05c5\u05c6\u0007"+
		"\r\u0000\u0000\u05c6\u05cb\u0003\u00ceg\u0000\u05c7\u05c8\u0005\f\u0000"+
		"\u0000\u05c8\u05c9\u0007\r\u0000\u0000\u05c9\u05cb\u0003\u00ceg\u0000"+
		"\u05ca\u05bf\u0001\u0000\u0000\u0000\u05ca\u05c7\u0001\u0000\u0000\u0000"+
		"\u05cb\u00cb\u0001\u0000\u0000\u0000\u05cc\u05cd\u0006f\uffff\uffff\u0000"+
		"\u05cd\u05ce\u0005N\u0000\u0000\u05ce\u05cf\u0003\u00ccf\u0000\u05cf\u05d0"+
		"\u0005O\u0000\u0000\u05d0\u05e7\u0001\u0000\u0000\u0000\u05d1\u05d3\u0003"+
		"\f\u0006\u0000\u05d2\u05d1\u0001\u0000\u0000\u0000\u05d3\u05d6\u0001\u0000"+
		"\u0000\u0000\u05d4\u05d2\u0001\u0000\u0000\u0000\u05d4\u05d5\u0001\u0000"+
		"\u0000\u0000\u05d5\u05d7\u0001\u0000\u0000\u0000\u05d6\u05d4\u0001\u0000"+
		"\u0000\u0000\u05d7\u05db\u0003\u00e6s\u0000\u05d8\u05da\u0003p8\u0000"+
		"\u05d9\u05d8\u0001\u0000\u0000\u0000\u05da\u05dd\u0001\u0000\u0000\u0000"+
		"\u05db\u05d9\u0001\u0000\u0000\u0000\u05db\u05dc\u0001\u0000\u0000\u0000"+
		"\u05dc\u05de\u0001\u0000\u0000\u0000\u05dd\u05db\u0001\u0000\u0000\u0000"+
		"\u05de\u05e3\u0003\u0098L\u0000\u05df\u05e0\u0005b\u0000\u0000\u05e0\u05e2"+
		"\u0003\u00bc^\u0000\u05e1\u05df\u0001\u0000\u0000\u0000\u05e2\u05e5\u0001"+
		"\u0000\u0000\u0000\u05e3\u05e1\u0001\u0000\u0000\u0000\u05e3\u05e4\u0001"+
		"\u0000\u0000\u0000\u05e4\u05e7\u0001\u0000\u0000\u0000\u05e5\u05e3\u0001"+
		"\u0000\u0000\u0000\u05e6\u05cc\u0001\u0000\u0000\u0000\u05e6\u05d4\u0001"+
		"\u0000\u0000\u0000\u05e7\u05ed\u0001\u0000\u0000\u0000\u05e8\u05e9\n\u0001"+
		"\u0000\u0000\u05e9\u05ea\u0005b\u0000\u0000\u05ea\u05ec\u0003\u00bc^\u0000"+
		"\u05eb\u05e8\u0001\u0000\u0000\u0000\u05ec\u05ef\u0001\u0000\u0000\u0000"+
		"\u05ed\u05eb\u0001\u0000\u0000\u0000\u05ed\u05ee\u0001\u0000\u0000\u0000"+
		"\u05ee\u00cd\u0001\u0000\u0000\u0000\u05ef\u05ed\u0001\u0000\u0000\u0000"+
		"\u05f0\u05f8\u0003\u0092I\u0000\u05f1\u05f3\u0003\u0094J\u0000\u05f2\u05f1"+
		"\u0001\u0000\u0000\u0000\u05f3\u05f6\u0001\u0000\u0000\u0000\u05f4\u05f2"+
		"\u0001\u0000\u0000\u0000\u05f4\u05f5\u0001\u0000\u0000\u0000\u05f5\u05f8"+
		"\u0001\u0000\u0000\u0000\u05f6\u05f4\u0001\u0000\u0000\u0000\u05f7\u05f0"+
		"\u0001\u0000\u0000\u0000\u05f7\u05f4\u0001\u0000\u0000\u0000\u05f8\u00cf"+
		"\u0001\u0000\u0000\u0000\u05f9\u05fa\u0003R)\u0000\u05fa\u05fb\u0005V"+
		"\u0000\u0000\u05fb\u05fd\u0001\u0000\u0000\u0000\u05fc\u05f9\u0001\u0000"+
		"\u0000\u0000\u05fc\u05fd\u0001\u0000\u0000\u0000\u05fd\u0601\u0001\u0000"+
		"\u0000\u0000\u05fe\u0600\u0003p8\u0000\u05ff\u05fe\u0001\u0000\u0000\u0000"+
		"\u0600\u0603\u0001\u0000\u0000\u0000\u0601\u05ff\u0001\u0000\u0000\u0000"+
		"\u0601\u0602\u0001\u0000\u0000\u0000\u0602\u0604\u0001\u0000\u0000\u0000"+
		"\u0603\u0601\u0001\u0000\u0000\u0000\u0604\u0606\u0003\u0098L\u0000\u0605"+
		"\u0607\u0003\u00eau\u0000\u0606\u0605\u0001\u0000\u0000\u0000\u0606\u0607"+
		"\u0001\u0000\u0000\u0000\u0607\u00d1\u0001\u0000\u0000\u0000\u0608\u060a"+
		"\u0003\u00e2q\u0000\u0609\u0608\u0001\u0000\u0000\u0000\u0609\u060a\u0001"+
		"\u0000\u0000\u0000\u060a\u060b\u0001\u0000\u0000\u0000\u060b\u060c\u0003"+
		"\u00d4j\u0000\u060c\u060d\u0003\u00dam\u0000\u060d\u0612\u0001\u0000\u0000"+
		"\u0000\u060e\u060f\u0003\u00d4j\u0000\u060f\u0610\u0003\u00d8l\u0000\u0610"+
		"\u0612\u0001\u0000\u0000\u0000\u0611\u0609\u0001\u0000\u0000\u0000\u0611"+
		"\u060e\u0001\u0000\u0000\u0000\u0612\u00d3\u0001\u0000\u0000\u0000\u0613"+
		"\u0615\u0003\u0098L\u0000\u0614\u0616\u0003\u00deo\u0000\u0615\u0614\u0001"+
		"\u0000\u0000\u0000\u0615\u0616\u0001\u0000\u0000\u0000\u0616\u061e\u0001"+
		"\u0000\u0000\u0000\u0617\u0618\u0005V\u0000\u0000\u0618\u061a\u0003\u0098"+
		"L\u0000\u0619\u061b\u0003\u00deo\u0000\u061a\u0619\u0001\u0000\u0000\u0000"+
		"\u061a\u061b\u0001\u0000\u0000\u0000\u061b\u061d\u0001\u0000\u0000\u0000"+
		"\u061c\u0617\u0001\u0000\u0000\u0000\u061d\u0620\u0001\u0000\u0000\u0000"+
		"\u061e\u061c\u0001\u0000\u0000\u0000\u061e\u061f\u0001\u0000\u0000\u0000"+
		"\u061f\u0623\u0001\u0000\u0000\u0000\u0620\u061e\u0001\u0000\u0000\u0000"+
		"\u0621\u0623\u0003\u00e8t\u0000\u0622\u0613\u0001\u0000\u0000\u0000\u0622"+
		"\u0621\u0001\u0000\u0000\u0000\u0623\u00d5\u0001\u0000\u0000\u0000\u0624"+
		"\u0626\u0003\u0098L\u0000\u0625\u0627\u0003\u00e0p\u0000\u0626\u0625\u0001"+
		"\u0000\u0000\u0000\u0626\u0627\u0001\u0000\u0000\u0000\u0627\u0628\u0001"+
		"\u0000\u0000\u0000\u0628\u0629\u0003\u00dam\u0000\u0629\u00d7\u0001\u0000"+
		"\u0000\u0000\u062a\u062b\u0005R\u0000\u0000\u062b\u062d\u0005S\u0000\u0000"+
		"\u062c\u062a\u0001\u0000\u0000\u0000\u062d\u062e\u0001\u0000\u0000\u0000"+
		"\u062e\u062c\u0001\u0000\u0000\u0000\u062e\u062f\u0001\u0000\u0000\u0000"+
		"\u062f\u0630\u0001\u0000\u0000\u0000\u0630\u0641\u0003P(\u0000\u0631\u0632"+
		"\u0005R\u0000\u0000\u0632\u0633\u0003\u00bc^\u0000\u0633\u0634\u0005S"+
		"\u0000\u0000\u0634\u0636\u0001\u0000\u0000\u0000\u0635\u0631\u0001\u0000"+
		"\u0000\u0000\u0636\u0637\u0001\u0000\u0000\u0000\u0637\u0635\u0001\u0000"+
		"\u0000\u0000\u0637\u0638\u0001\u0000\u0000\u0000\u0638\u063d\u0001\u0000"+
		"\u0000\u0000\u0639\u063a\u0005R\u0000\u0000\u063a\u063c\u0005S\u0000\u0000"+
		"\u063b\u0639\u0001\u0000\u0000\u0000\u063c\u063f\u0001\u0000\u0000\u0000"+
		"\u063d\u063b\u0001\u0000\u0000\u0000\u063d\u063e\u0001\u0000\u0000\u0000"+
		"\u063e\u0641\u0001\u0000\u0000\u0000\u063f\u063d\u0001\u0000\u0000\u0000"+
		"\u0640\u062c\u0001\u0000\u0000\u0000\u0640\u0635\u0001\u0000\u0000\u0000"+
		"\u0641\u00d9\u0001\u0000\u0000\u0000\u0642\u0644\u0003\u00f0x\u0000\u0643"+
		"\u0645\u0003 \u0010\u0000\u0644\u0643\u0001\u0000\u0000\u0000\u0644\u0645"+
		"\u0001\u0000\u0000\u0000\u0645\u00db\u0001\u0000\u0000\u0000\u0646\u0647"+
		"\u0003\u00e2q\u0000\u0647\u0648\u0003\u00eew\u0000\u0648\u00dd\u0001\u0000"+
		"\u0000\u0000\u0649\u064a\u0005Y\u0000\u0000\u064a\u064d\u0005X\u0000\u0000"+
		"\u064b\u064d\u0003\u00eau\u0000\u064c\u0649\u0001\u0000\u0000\u0000\u064c"+
		"\u064b\u0001\u0000\u0000\u0000\u064d\u00df\u0001\u0000\u0000\u0000\u064e"+
		"\u064f\u0005Y\u0000\u0000\u064f\u0652\u0005X\u0000\u0000\u0650\u0652\u0003"+
		"\u00e2q\u0000\u0651\u064e\u0001\u0000\u0000\u0000\u0651\u0650\u0001\u0000"+
		"\u0000\u0000\u0652\u00e1\u0001\u0000\u0000\u0000\u0653\u0654\u0005Y\u0000"+
		"\u0000\u0654\u0655\u0003\u00e4r\u0000\u0655\u0656\u0005X\u0000\u0000\u0656"+
		"\u00e3\u0001\u0000\u0000\u0000\u0657\u065c\u0003\u00e6s\u0000\u0658\u0659"+
		"\u0005U\u0000\u0000\u0659\u065b\u0003\u00e6s\u0000\u065a\u0658\u0001\u0000"+
		"\u0000\u0000\u065b\u065e\u0001\u0000\u0000\u0000\u065c\u065a\u0001\u0000"+
		"\u0000\u0000\u065c\u065d\u0001\u0000\u0000\u0000\u065d\u00e5\u0001\u0000"+
		"\u0000\u0000\u065e\u065c\u0001\u0000\u0000\u0000\u065f\u0661\u0003p8\u0000"+
		"\u0660\u065f\u0001\u0000\u0000\u0000\u0661\u0664\u0001\u0000\u0000\u0000"+
		"\u0662\u0660\u0001\u0000\u0000\u0000\u0662\u0663\u0001\u0000\u0000\u0000"+
		"\u0663\u0667\u0001\u0000\u0000\u0000\u0664\u0662\u0001\u0000\u0000\u0000"+
		"\u0665\u0668\u0003R)\u0000\u0666\u0668\u0003\u00e8t\u0000\u0667\u0665"+
		"\u0001\u0000\u0000\u0000\u0667\u0666\u0001\u0000\u0000\u0000\u0668\u0673"+
		"\u0001\u0000\u0000\u0000\u0669\u066b\u0003p8\u0000\u066a\u0669\u0001\u0000"+
		"\u0000\u0000\u066b\u066e\u0001\u0000\u0000\u0000\u066c\u066a\u0001\u0000"+
		"\u0000\u0000\u066c\u066d\u0001\u0000\u0000\u0000\u066d\u066f\u0001\u0000"+
		"\u0000\u0000\u066e\u066c\u0001\u0000\u0000\u0000\u066f\u0670\u0005R\u0000"+
		"\u0000\u0670\u0672\u0005S\u0000\u0000\u0671\u066c\u0001\u0000\u0000\u0000"+
		"\u0672\u0675\u0001\u0000\u0000\u0000\u0673\u0671\u0001\u0000\u0000\u0000"+
		"\u0673\u0674\u0001\u0000\u0000\u0000\u0674\u00e7\u0001\u0000\u0000\u0000"+
		"\u0675\u0673\u0001\u0000\u0000\u0000\u0676\u0677\u0007\u000e\u0000\u0000"+
		"\u0677\u00e9\u0001\u0000\u0000\u0000\u0678\u0679\u0005Y\u0000\u0000\u0679"+
		"\u067e\u0003T*\u0000\u067a\u067b\u0005U\u0000\u0000\u067b\u067d\u0003"+
		"T*\u0000\u067c\u067a\u0001\u0000\u0000\u0000\u067d\u0680\u0001\u0000\u0000"+
		"\u0000\u067e\u067c\u0001\u0000\u0000\u0000\u067e\u067f\u0001\u0000\u0000"+
		"\u0000\u067f\u0681\u0001\u0000\u0000\u0000\u0680\u067e\u0001\u0000\u0000"+
		"\u0000\u0681\u0682\u0005X\u0000\u0000\u0682\u00eb\u0001\u0000\u0000\u0000"+
		"\u0683\u068d\u0003\u00f0x\u0000\u0684\u0686\u0005V\u0000\u0000\u0685\u0687"+
		"\u0003\u00eau\u0000\u0686\u0685\u0001\u0000\u0000\u0000\u0686\u0687\u0001"+
		"\u0000\u0000\u0000\u0687\u0688\u0001\u0000\u0000\u0000\u0688\u068a\u0003"+
		"\u0098L\u0000\u0689\u068b\u0003\u00f0x\u0000\u068a\u0689\u0001\u0000\u0000"+
		"\u0000\u068a\u068b\u0001\u0000\u0000\u0000\u068b\u068d\u0001\u0000\u0000"+
		"\u0000\u068c\u0683\u0001\u0000\u0000\u0000\u068c\u0684\u0001\u0000\u0000"+
		"\u0000\u068d\u00ed\u0001\u0000\u0000\u0000\u068e\u068f\u0005(\u0000\u0000"+
		"\u068f\u0694\u0003\u00ecv\u0000\u0690\u0691\u0003\u0098L\u0000\u0691\u0692"+
		"\u0003\u00f0x\u0000\u0692\u0694\u0001\u0000\u0000\u0000\u0693\u068e\u0001"+
		"\u0000\u0000\u0000\u0693\u0690\u0001\u0000\u0000\u0000\u0694\u00ef\u0001"+
		"\u0000\u0000\u0000\u0695\u0697\u0005N\u0000\u0000\u0696\u0698\u0003\u00b8"+
		"\\\u0000\u0697\u0696\u0001\u0000\u0000\u0000\u0697\u0698\u0001\u0000\u0000"+
		"\u0000\u0698\u0699\u0001\u0000\u0000\u0000\u0699\u069a\u0005O\u0000\u0000"+
		"\u069a\u00f1\u0001\u0000\u0000\u0000\u00d3\u00f3\u00f7\u00f9\u00fe\u0100"+
		"\u0106\u010b\u0114\u0119\u0120\u0127\u012e\u0138\u013c\u0141\u0145\u0149"+
		"\u0153\u015b\u0163\u0167\u016e\u0175\u0179\u017c\u017f\u0188\u018e\u0193"+
		"\u0196\u019c\u01a2\u01a6\u01aa\u01b2\u01bb\u01c2\u01c8\u01cc\u01d7\u01e0"+
		"\u01e5\u01eb\u01ef\u01fb\u0202\u020f\u0214\u021d\u0225\u022f\u0238\u0243"+
		"\u0248\u0251\u025b\u0260\u0269\u026f\u0276\u027b\u0283\u0287\u0289\u028f"+
		"\u0295\u029a\u02a0\u02a6\u02a8\u02af\u02b4\u02b9\u02bc\u02be\u02c8\u02d2"+
		"\u02d7\u02da\u02df\u02e8\u02ef\u02fa\u0300\u030b\u0315\u0320\u0329\u032e"+
		"\u0331\u0338\u0342\u034a\u034d\u0350\u035d\u0365\u036a\u0372\u0376\u037a"+
		"\u037e\u0380\u0384\u038a\u0392\u039c\u03a5\u03af\u03b7\u03c5\u03cd\u03d7"+
		"\u03dc\u03e7\u03f0\u03f5\u03fc\u0405\u041c\u041f\u0422\u042a\u042e\u0436"+
		"\u043c\u0447\u0450\u0455\u0462\u0468\u046f\u047c\u0485\u048e\u0494\u049c"+
		"\u04a2\u04a7\u04ac\u04b4\u04b9\u04bd\u04c1\u04c5\u04c7\u04cb\u04d0\u04d5"+
		"\u04e4\u04ea\u04f4\u04f8\u04fd\u0508\u0510\u0519\u0529\u0556\u055c\u0561"+
		"\u056a\u056c\u056e\u0574\u057b\u0587\u0590\u0597\u059a\u059e\u05b0\u05b2"+
		"\u05ba\u05c3\u05ca\u05d4\u05db\u05e3\u05e6\u05ed\u05f4\u05f7\u05fc\u0601"+
		"\u0606\u0609\u0611\u0615\u061a\u061e\u0622\u0626\u062e\u0637\u063d\u0640"+
		"\u0644\u064c\u0651\u065c\u0662\u0667\u066c\u0673\u067e\u0686\u068a\u068c"+
		"\u0693\u0697";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}