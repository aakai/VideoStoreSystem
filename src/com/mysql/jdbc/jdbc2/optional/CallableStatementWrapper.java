/*
 Copyright (c) 2002, 2010, Oracle and/or its affiliates. All rights reserved.
 

  The MySQL Connector/J is licensed under the terms of the GPLv2
  <http://www.gnu.org/licenses/old-licenses/gpl-2.0.html>, like most MySQL Connectors.
  There are special exceptions to the terms and conditions of the GPLv2 as it is applied to
  this software, see the FLOSS License Exception
  <http://www.mysql.com/about/legal/licensing/foss-exception.html>.

  This program is free software; you can redistribute it and/or modify it under the terms
  of the GNU General Public License as published by the Free Software Foundation; version 2
  of the License.

  This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
  without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
  See the GNU General Public License for more details.

  You should have received a copy of the GNU General Public License along with this
  program; if not, write to the Free Software Foundation, Inc., 51 Franklin St, Fifth
  Floor, Boston, MA 02110-1301  USA


 */

package com.mysql.jdbc.jdbc2.optional;

import java.io.InputStream;
import java.io.Reader;
import java.lang.reflect.Constructor;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.CallableStatement;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.Ref;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Map;

import com.mysql.jdbc.SQLError;
import com.mysql.jdbc.Util;

/**
 * Wraps callable statements created by pooled connections.
 * 
 * @version $Id: CallableStatementWrapper.java,v 1.1.2.1 2005/05/13 18:58:38
 *          mmatthews Exp $
 */
public class CallableStatementWrapper extends PreparedStatementWrapper
		implements CallableStatement {

private static final Constructor JDBC_4_CALLABLE_STATEMENT_WRAPPER_CTOR;
	
	static {
		if (Util.isJdbc4()) {
			try {
				JDBC_4_CALLABLE_STATEMENT_WRAPPER_CTOR = Class.forName(
						"com.mysql.jdbc.jdbc2.optional.JDBC4CallableStatementWrapper").getConstructor(
						new Class[] { ConnectionWrapper.class, 
								MysqlPooledConnection.class, 
								CallableStatement.class });
			} catch (SecurityException e) {
				throw new RuntimeException(e);
			} catch (NoSuchMethodException e) {
				throw new RuntimeException(e);
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
		} else {
			JDBC_4_CALLABLE_STATEMENT_WRAPPER_CTOR = null;
		}
	}
	
	protected static CallableStatementWrapper getInstance(ConnectionWrapper c, 
			MysqlPooledConnection conn,
			CallableStatement toWrap) throws SQLException {
		if (!Util.isJdbc4()) {
			return new CallableStatementWrapper(c, 
					conn, toWrap);
		}

		return (CallableStatementWrapper) Util.handleNewInstance(
				JDBC_4_CALLABLE_STATEMENT_WRAPPER_CTOR,
				new Object[] {c, 
						conn, toWrap }, conn.getExceptionInterceptor());
	}
	
	
	
	/**
	 * @param c
	 * @param conn
	 * @param toWrap
	 */
	public CallableStatementWrapper(ConnectionWrapper c,
			MysqlPooledConnection conn, CallableStatement toWrap) {
		super(c, conn, toWrap);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#registerOutParameter(int, int)
	 */
	public void registerOutParameter(int parameterIndex, int sqlType)
			throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				((CallableStatement) this.wrappedStmt).registerOutParameter(
						parameterIndex, sqlType);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#registerOutParameter(int, int, int)
	 */
	public void registerOutParameter(int parameterIndex, int sqlType, int scale)
			throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				((CallableStatement) this.wrappedStmt).registerOutParameter(
						parameterIndex, sqlType, scale);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#wasNull()
	 */
	public boolean wasNull() throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				return ((CallableStatement) this.wrappedStmt).wasNull();
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#getString(int)
	 */
	public String getString(int parameterIndex) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				return ((CallableStatement) this.wrappedStmt)
						.getString(parameterIndex);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#getBoolean(int)
	 */
	public boolean getBoolean(int parameterIndex) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				return ((CallableStatement) this.wrappedStmt)
						.getBoolean(parameterIndex);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#getByte(int)
	 */
	public byte getByte(int parameterIndex) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				return ((CallableStatement) this.wrappedStmt)
						.getByte(parameterIndex);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}

		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#getShort(int)
	 */
	public short getShort(int parameterIndex) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				return ((CallableStatement) this.wrappedStmt)
						.getShort(parameterIndex);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}

		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#getInt(int)
	 */
	public int getInt(int parameterIndex) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				return ((CallableStatement) this.wrappedStmt)
						.getInt(parameterIndex);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}

		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#getLong(int)
	 */
	public long getLong(int parameterIndex) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				return ((CallableStatement) this.wrappedStmt)
						.getLong(parameterIndex);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}

		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#getFloat(int)
	 */
	public float getFloat(int parameterIndex) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				return ((CallableStatement) this.wrappedStmt)
						.getFloat(parameterIndex);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}

		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#getDouble(int)
	 */
	public double getDouble(int parameterIndex) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				return ((CallableStatement) this.wrappedStmt)
						.getDouble(parameterIndex);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}

		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#getBigDecimal(int, int)
	 */
	public BigDecimal getBigDecimal(int parameterIndex, int scale)
			throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				return ((CallableStatement) this.wrappedStmt).getBigDecimal(
						parameterIndex, scale);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#getBytes(int)
	 */
	public byte[] getBytes(int parameterIndex) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				return ((CallableStatement) this.wrappedStmt)
						.getBytes(parameterIndex);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#getDate(int)
	 */
	public Date getDate(int parameterIndex) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				return ((CallableStatement) this.wrappedStmt)
						.getDate(parameterIndex);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#getTime(int)
	 */
	public Time getTime(int parameterIndex) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				return ((CallableStatement) this.wrappedStmt)
						.getTime(parameterIndex);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#getTimestamp(int)
	 */
	public Timestamp getTimestamp(int parameterIndex) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				return ((CallableStatement) this.wrappedStmt)
						.getTimestamp(parameterIndex);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#getObject(int)
	 */
	public Object getObject(int parameterIndex) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				return ((CallableStatement) this.wrappedStmt)
						.getObject(parameterIndex);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#getBigDecimal(int)
	 */
	public BigDecimal getBigDecimal(int parameterIndex) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				return ((CallableStatement) this.wrappedStmt)
						.getBigDecimal(parameterIndex);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#getObject(int, java.util.Map)
	 */
	public Object getObject(int parameterIndex, Map typeMap)
			throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				return ((CallableStatement) this.wrappedStmt).getObject(
						parameterIndex, typeMap);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#getRef(int)
	 */
	public Ref getRef(int parameterIndex) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				return ((CallableStatement) this.wrappedStmt)
						.getRef(parameterIndex);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#getBlob(int)
	 */
	public Blob getBlob(int parameterIndex) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				return ((CallableStatement) this.wrappedStmt)
						.getBlob(parameterIndex);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#getClob(int)
	 */
	public Clob getClob(int parameterIndex) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				return ((CallableStatement) this.wrappedStmt)
						.getClob(parameterIndex);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#getArray(int)
	 */
	public Array getArray(int parameterIndex) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				return ((CallableStatement) this.wrappedStmt)
						.getArray(parameterIndex);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#getDate(int, java.util.Calendar)
	 */
	public Date getDate(int parameterIndex, Calendar cal) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				return ((CallableStatement) this.wrappedStmt).getDate(
						parameterIndex, cal);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#getTime(int, java.util.Calendar)
	 */
	public Time getTime(int parameterIndex, Calendar cal) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				return ((CallableStatement) this.wrappedStmt).getTime(
						parameterIndex, cal);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#getTimestamp(int, java.util.Calendar)
	 */
	public Timestamp getTimestamp(int parameterIndex, Calendar cal)
			throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				return ((CallableStatement) this.wrappedStmt).getTimestamp(
						parameterIndex, cal);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#registerOutParameter(int, int,
	 *      java.lang.String)
	 */
	public void registerOutParameter(int paramIndex, int sqlType,
			String typeName) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				((CallableStatement) this.wrappedStmt).registerOutParameter(
						paramIndex, sqlType, typeName);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#registerOutParameter(java.lang.String,
	 *      int)
	 */
	public void registerOutParameter(String parameterName, int sqlType)
			throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				((CallableStatement) this.wrappedStmt).registerOutParameter(
						parameterName, sqlType);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#registerOutParameter(java.lang.String,
	 *      int, int)
	 */
	public void registerOutParameter(String parameterName, int sqlType,
			int scale) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				((CallableStatement) this.wrappedStmt).registerOutParameter(
						parameterName, sqlType, scale);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#registerOutParameter(java.lang.String,
	 *      int, java.lang.String)
	 */
	public void registerOutParameter(String parameterName, int sqlType,
			String typeName) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				((CallableStatement) this.wrappedStmt).registerOutParameter(
						parameterName, sqlType, typeName);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#getURL(int)
	 */
	public URL getURL(int parameterIndex) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				return ((CallableStatement) this.wrappedStmt)
						.getURL(parameterIndex);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#setURL(java.lang.String, java.net.URL)
	 */
	public void setURL(String parameterName, URL val) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				((CallableStatement) this.wrappedStmt).setURL(parameterName,
						val);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#setNull(java.lang.String, int)
	 */
	public void setNull(String parameterName, int sqlType) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				((CallableStatement) this.wrappedStmt).setNull(parameterName,
						sqlType);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#setBoolean(java.lang.String, boolean)
	 */
	public void setBoolean(String parameterName, boolean x) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				((CallableStatement) this.wrappedStmt).setBoolean(
						parameterName, x);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#setByte(java.lang.String, byte)
	 */
	public void setByte(String parameterName, byte x) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				((CallableStatement) this.wrappedStmt)
						.setByte(parameterName, x);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#setShort(java.lang.String, short)
	 */
	public void setShort(String parameterName, short x) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				((CallableStatement) this.wrappedStmt).setShort(parameterName,
						x);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#setInt(java.lang.String, int)
	 */
	public void setInt(String parameterName, int x) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				((CallableStatement) this.wrappedStmt).setInt(parameterName, x);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#setLong(java.lang.String, long)
	 */
	public void setLong(String parameterName, long x) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				((CallableStatement) this.wrappedStmt)
						.setLong(parameterName, x);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#setFloat(java.lang.String, float)
	 */
	public void setFloat(String parameterName, float x) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				((CallableStatement) this.wrappedStmt).setFloat(parameterName,
						x);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#setDouble(java.lang.String, double)
	 */
	public void setDouble(String parameterName, double x) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				((CallableStatement) this.wrappedStmt).setDouble(parameterName,
						x);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#setBigDecimal(java.lang.String,
	 *      java.math.BigDecimal)
	 */
	public void setBigDecimal(String parameterName, BigDecimal x)
			throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				((CallableStatement) this.wrappedStmt).setBigDecimal(
						parameterName, x);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#setString(java.lang.String,
	 *      java.lang.String)
	 */
	public void setString(String parameterName, String x) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				((CallableStatement) this.wrappedStmt).setString(parameterName,
						x);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#setBytes(java.lang.String, byte[])
	 */
	public void setBytes(String parameterName, byte[] x) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				((CallableStatement) this.wrappedStmt).setBytes(parameterName,
						x);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#setDate(java.lang.String, java.sql.Date)
	 */
	public void setDate(String parameterName, Date x) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				((CallableStatement) this.wrappedStmt)
						.setDate(parameterName, x);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#setTime(java.lang.String, java.sql.Time)
	 */
	public void setTime(String parameterName, Time x) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				((CallableStatement) this.wrappedStmt)
						.setTime(parameterName, x);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#setTimestamp(java.lang.String,
	 *      java.sql.Timestamp)
	 */
	public void setTimestamp(String parameterName, Timestamp x)
			throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				((CallableStatement) this.wrappedStmt).setTimestamp(
						parameterName, x);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#setAsciiStream(java.lang.String,
	 *      java.io.InputStream, int)
	 */
	public void setAsciiStream(String parameterName, InputStream x, int length)
			throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				((CallableStatement) this.wrappedStmt).setAsciiStream(
						parameterName, x, length);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#setBinaryStream(java.lang.String,
	 *      java.io.InputStream, int)
	 */
	public void setBinaryStream(String parameterName, InputStream x, int length)
			throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				((CallableStatement) this.wrappedStmt).setBinaryStream(
						parameterName, x, length);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#setObject(java.lang.String,
	 *      java.lang.Object, int, int)
	 */
	public void setObject(String parameterName, Object x, int targetSqlType,
			int scale) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				((CallableStatement) this.wrappedStmt).setObject(parameterName,
						x, targetSqlType, scale);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#setObject(java.lang.String,
	 *      java.lang.Object, int)
	 */
	public void setObject(String parameterName, Object x, int targetSqlType)
			throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				((CallableStatement) this.wrappedStmt).setObject(parameterName,
						x, targetSqlType);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#setObject(java.lang.String,
	 *      java.lang.Object)
	 */
	public void setObject(String parameterName, Object x) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				((CallableStatement) this.wrappedStmt).setObject(parameterName,
						x);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#setCharacterStream(java.lang.String,
	 *      java.io.Reader, int)
	 */
	public void setCharacterStream(String parameterName, Reader reader,
			int length) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				((CallableStatement) this.wrappedStmt).setCharacterStream(
						parameterName, reader, length);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#setDate(java.lang.String, java.sql.Date,
	 *      java.util.Calendar)
	 */
	public void setDate(String parameterName, Date x, Calendar cal)
			throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				((CallableStatement) this.wrappedStmt).setDate(parameterName,
						x, cal);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#setTime(java.lang.String, java.sql.Time,
	 *      java.util.Calendar)
	 */
	public void setTime(String parameterName, Time x, Calendar cal)
			throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				((CallableStatement) this.wrappedStmt).setTime(parameterName,
						x, cal);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#setTimestamp(java.lang.String,
	 *      java.sql.Timestamp, java.util.Calendar)
	 */
	public void setTimestamp(String parameterName, Timestamp x, Calendar cal)
			throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				((CallableStatement) this.wrappedStmt).setTimestamp(
						parameterName, x, cal);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#setNull(java.lang.String, int,
	 *      java.lang.String)
	 */
	public void setNull(String parameterName, int sqlType, String typeName)
			throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				((CallableStatement) this.wrappedStmt).setNull(parameterName,
						sqlType, typeName);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#getString(int)
	 */
	public String getString(String parameterName) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				return ((CallableStatement) this.wrappedStmt)
						.getString(parameterName);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#getBoolean(int)
	 */
	public boolean getBoolean(String parameterName) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				return ((CallableStatement) this.wrappedStmt)
						.getBoolean(parameterName);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}

		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#getByte(int)
	 */
	public byte getByte(String parameterName) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				return ((CallableStatement) this.wrappedStmt)
						.getByte(parameterName);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}

		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#getShort(int)
	 */
	public short getShort(String parameterName) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				return ((CallableStatement) this.wrappedStmt)
						.getShort(parameterName);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}

		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#getInt(int)
	 */
	public int getInt(String parameterName) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				return ((CallableStatement) this.wrappedStmt)
						.getInt(parameterName);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}

		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#getLong(int)
	 */
	public long getLong(String parameterName) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				return ((CallableStatement) this.wrappedStmt)
						.getLong(parameterName);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}

		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#getFloat(int)
	 */
	public float getFloat(String parameterName) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				return ((CallableStatement) this.wrappedStmt)
						.getFloat(parameterName);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}

		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#getDouble(int)
	 */
	public double getDouble(String parameterName) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				return ((CallableStatement) this.wrappedStmt)
						.getDouble(parameterName);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}

		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#getBytes(int)
	 */
	public byte[] getBytes(String parameterName) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				return ((CallableStatement) this.wrappedStmt)
						.getBytes(parameterName);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#getDate(int)
	 */
	public Date getDate(String parameterName) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				return ((CallableStatement) this.wrappedStmt)
						.getDate(parameterName);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#getTime(int)
	 */
	public Time getTime(String parameterName) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				return ((CallableStatement) this.wrappedStmt)
						.getTime(parameterName);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#getTimestamp(int)
	 */
	public Timestamp getTimestamp(String parameterName) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				return ((CallableStatement) this.wrappedStmt)
						.getTimestamp(parameterName);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#getObject(int)
	 */
	public Object getObject(String parameterName) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				return ((CallableStatement) this.wrappedStmt)
						.getObject(parameterName);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#getBigDecimal(int)
	 */
	public BigDecimal getBigDecimal(String parameterName) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				return ((CallableStatement) this.wrappedStmt)
						.getBigDecimal(parameterName);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#getObject(int, java.util.Map)
	 */
	public Object getObject(String parameterName, Map typeMap)
			throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				return ((CallableStatement) this.wrappedStmt).getObject(
						parameterName, typeMap);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#getRef(int)
	 */
	public Ref getRef(String parameterName) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				return ((CallableStatement) this.wrappedStmt)
						.getRef(parameterName);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#getBlob(int)
	 */
	public Blob getBlob(String parameterName) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				return ((CallableStatement) this.wrappedStmt)
						.getBlob(parameterName);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#getClob(int)
	 */
	public Clob getClob(String parameterName) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				return ((CallableStatement) this.wrappedStmt)
						.getClob(parameterName);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#getArray(int)
	 */
	public Array getArray(String parameterName) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				return ((CallableStatement) this.wrappedStmt)
						.getArray(parameterName);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#getDate(int, java.util.Calendar)
	 */
	public Date getDate(String parameterName, Calendar cal) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				return ((CallableStatement) this.wrappedStmt).getDate(
						parameterName, cal);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#getTime(int, java.util.Calendar)
	 */
	public Time getTime(String parameterName, Calendar cal) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				return ((CallableStatement) this.wrappedStmt).getTime(
						parameterName, cal);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#getTimestamp(int, java.util.Calendar)
	 */
	public Timestamp getTimestamp(String parameterName, Calendar cal)
			throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				return ((CallableStatement) this.wrappedStmt).getTimestamp(
						parameterName, cal);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.sql.CallableStatement#getURL(java.lang.String)
	 */
	public URL getURL(String parameterName) throws SQLException {
		try {
			if (this.wrappedStmt != null) {
				return ((CallableStatement) this.wrappedStmt)
						.getURL(parameterName);
			} else {
				throw SQLError.createSQLException(
						"No operations allowed after statement closed",
						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
			}
		} catch (SQLException sqlEx) {
			checkAndFireConnectionError(sqlEx);
		}

		return null;
	}
//
//	public Reader getCharacterStream(int parameterIndex) throws SQLException {
//		try {
//			if (this.wrappedStmt != null) {
//				return ((CallableStatement) this.wrappedStmt)
//						.getCharacterStream(parameterIndex);
//			} else {
//				throw SQLError.createSQLException(
//						"No operations allowed after statement closed",
//						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
//			}
//		} catch (SQLException sqlEx) {
//			checkAndFireConnectionError(sqlEx);
//		}
//		
//		return null;
//	}
//
//	public Reader getCharacterStream(String parameterName) throws SQLException {
//		try {
//			if (this.wrappedStmt != null) {
//				return ((CallableStatement) this.wrappedStmt)
//						.getCharacterStream(parameterName);
//			} else {
//				throw SQLError.createSQLException(
//						"No operations allowed after statement closed",
//						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
//			}
//		} catch (SQLException sqlEx) {
//			checkAndFireConnectionError(sqlEx);
//		}
//		
//		return null;
//	}
//
//	public Reader getNCharacterStream(int parameterIndex) throws SQLException {
//		try {
//			if (this.wrappedStmt != null) {
//				return ((CallableStatement) this.wrappedStmt)
//						.getCharacterStream(parameterIndex);
//			} else {
//				throw SQLError.createSQLException(
//						"No operations allowed after statement closed",
//						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
//			}
//		} catch (SQLException sqlEx) {
//			checkAndFireConnectionError(sqlEx);
//		}
//		
//		return null;
//	}
//
//	public Reader getNCharacterStream(String parameterName) throws SQLException {
//		try {
//			if (this.wrappedStmt != null) {
//				return ((CallableStatement) this.wrappedStmt)
//						.getNCharacterStream(parameterName);
//			} else {
//				throw SQLError.createSQLException(
//						"No operations allowed after statement closed",
//						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
//			}
//		} catch (SQLException sqlEx) {
//			checkAndFireConnectionError(sqlEx);
//		}
//		
//		return null;
//	}
//
//	public NClob getNClob(int parameterIndex) throws SQLException {
//		try {
//			if (this.wrappedStmt != null) {
//				return ((CallableStatement) this.wrappedStmt)
//						.getNClob(parameterIndex);
//			} else {
//				throw SQLError.createSQLException(
//						"No operations allowed after statement closed",
//						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
//			}
//		} catch (SQLException sqlEx) {
//			checkAndFireConnectionError(sqlEx);
//		}
//		
//		return null;
//	}
//
//	public NClob getNClob(String parameterName) throws SQLException {
//		try {
//			if (this.wrappedStmt != null) {
//				return ((CallableStatement) this.wrappedStmt)
//						.getNClob(parameterName);
//			} else {
//				throw SQLError.createSQLException(
//						"No operations allowed after statement closed",
//						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
//			}
//		} catch (SQLException sqlEx) {
//			checkAndFireConnectionError(sqlEx);
//		}
//		
//		return null;
//	}
//
//	public String getNString(int parameterIndex) throws SQLException {
//		try {
//			if (this.wrappedStmt != null) {
//				return ((CallableStatement) this.wrappedStmt)
//						.getNString(parameterIndex);
//			} else {
//				throw SQLError.createSQLException(
//						"No operations allowed after statement closed",
//						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
//			}
//		} catch (SQLException sqlEx) {
//			checkAndFireConnectionError(sqlEx);
//		}
//		
//		return null;
//	}
//
//	public String getNString(String parameterName) throws SQLException {
//		try {
//			if (this.wrappedStmt != null) {
//				return ((CallableStatement) this.wrappedStmt)
//						.getNString(parameterName);
//			} else {
//				throw SQLError.createSQLException(
//						"No operations allowed after statement closed",
//						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
//			}
//		} catch (SQLException sqlEx) {
//			checkAndFireConnectionError(sqlEx);
//		}
//		
//		return null;
//	}
//
//	public RowId getRowId(int parameterIndex) throws SQLException {
//		try {
//			if (this.wrappedStmt != null) {
//				return ((CallableStatement) this.wrappedStmt)
//						.getRowId(parameterIndex);
//			} else {
//				throw SQLError.createSQLException(
//						"No operations allowed after statement closed",
//						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
//			}
//		} catch (SQLException sqlEx) {
//			checkAndFireConnectionError(sqlEx);
//		}
//		
//		return null;
//	}
//
//	public RowId getRowId(String parameterName) throws SQLException {
//		try {
//			if (this.wrappedStmt != null) {
//				return ((CallableStatement) this.wrappedStmt)
//						.getRowId(parameterName);
//			} else {
//				throw SQLError.createSQLException(
//						"No operations allowed after statement closed",
//						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
//			}
//		} catch (SQLException sqlEx) {
//			checkAndFireConnectionError(sqlEx);
//		}
//		
//		return null;
//	}
//
//	public SQLXML getSQLXML(int parameterIndex) throws SQLException {
//		try {
//			if (this.wrappedStmt != null) {
//				return ((CallableStatement) this.wrappedStmt)
//						.getSQLXML(parameterIndex);
//			} else {
//				throw SQLError.createSQLException(
//						"No operations allowed after statement closed",
//						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
//			}
//		} catch (SQLException sqlEx) {
//			checkAndFireConnectionError(sqlEx);
//		}
//		
//		return null;
//	}
//
//	public SQLXML getSQLXML(String parameterName) throws SQLException {
//		try {
//			if (this.wrappedStmt != null) {
//				return ((CallableStatement) this.wrappedStmt)
//						.getSQLXML(parameterName);
//			} else {
//				throw SQLError.createSQLException(
//						"No operations allowed after statement closed",
//						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
//			}
//		} catch (SQLException sqlEx) {
//			checkAndFireConnectionError(sqlEx);
//		}
//		
//		return null;
//	}
//
//	public void setAsciiStream(String parameterName, InputStream x) throws SQLException {
//		try {
//			if (this.wrappedStmt != null) {
//				((CallableStatement) this.wrappedStmt)
//						.setAsciiStream(parameterName, x) ;
//			} else {
//				throw SQLError.createSQLException(
//						"No operations allowed after statement closed",
//						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
//			}
//		} catch (SQLException sqlEx) {
//			checkAndFireConnectionError(sqlEx);
//		}
//	}
//
//	public void setAsciiStream(String parameterName, InputStream x, long length) throws SQLException {
//		try {
//			if (this.wrappedStmt != null) {
//				((CallableStatement) this.wrappedStmt)
//						.setAsciiStream(parameterName, x, length);
//			} else {
//				throw SQLError.createSQLException(
//						"No operations allowed after statement closed",
//						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
//			}
//		} catch (SQLException sqlEx) {
//			checkAndFireConnectionError(sqlEx);
//		}
//	}
//
//	public void setBinaryStream(String parameterName, InputStream x) throws SQLException {
//		try {
//			if (this.wrappedStmt != null) {
//				((CallableStatement) this.wrappedStmt)
//						.setBinaryStream(parameterName, x);
//			} else {
//				throw SQLError.createSQLException(
//						"No operations allowed after statement closed",
//						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
//			}
//		} catch (SQLException sqlEx) {
//			checkAndFireConnectionError(sqlEx);
//		}
//	}
//
//	public void setBinaryStream(String parameterName, InputStream x, long length) throws SQLException {
//		try {
//			if (this.wrappedStmt != null) {
//				((CallableStatement) this.wrappedStmt)
//						.setBinaryStream(parameterName, x, length);
//			} else {
//				throw SQLError.createSQLException(
//						"No operations allowed after statement closed",
//						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
//			}
//		} catch (SQLException sqlEx) {
//			checkAndFireConnectionError(sqlEx);
//		}
//	}
//
//	public void setBlob(String parameterName, Blob x) throws SQLException {
//		try {
//			if (this.wrappedStmt != null) {
//				((CallableStatement) this.wrappedStmt)
//						.setBlob(parameterName, x);
//			} else {
//				throw SQLError.createSQLException(
//						"No operations allowed after statement closed",
//						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
//			}
//		} catch (SQLException sqlEx) {
//			checkAndFireConnectionError(sqlEx);
//		}
//	}
//
//	public void setBlob(String parameterName, InputStream inputStream) throws SQLException {
//		try {
//			if (this.wrappedStmt != null) {
//				((CallableStatement) this.wrappedStmt)
//						.setBlob(parameterName, inputStream);
//			} else {
//				throw SQLError.createSQLException(
//						"No operations allowed after statement closed",
//						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
//			}
//		} catch (SQLException sqlEx) {
//			checkAndFireConnectionError(sqlEx);
//		}
//	}
//
//	public void setBlob(String parameterName, InputStream inputStream, long length) throws SQLException {
//		try {
//			if (this.wrappedStmt != null) {
//				((CallableStatement) this.wrappedStmt)
//						.setBlob(parameterName, inputStream, length);
//			} else {
//				throw SQLError.createSQLException(
//						"No operations allowed after statement closed",
//						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
//			}
//		} catch (SQLException sqlEx) {
//			checkAndFireConnectionError(sqlEx);
//		}
//	}
//
//	public void setCharacterStream(String parameterName, Reader reader) throws SQLException {
//		try {
//			if (this.wrappedStmt != null) {
//				((CallableStatement) this.wrappedStmt)
//						.setCharacterStream(parameterName, reader);
//			} else {
//				throw SQLError.createSQLException(
//						"No operations allowed after statement closed",
//						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
//			}
//		} catch (SQLException sqlEx) {
//			checkAndFireConnectionError(sqlEx);
//		}
//	}
//
//	public void setCharacterStream(String parameterName, Reader reader, long length) throws SQLException {
//		try {
//			if (this.wrappedStmt != null) {
//				((CallableStatement) this.wrappedStmt)
//						.setCharacterStream(parameterName, reader, length);
//			} else {
//				throw SQLError.createSQLException(
//						"No operations allowed after statement closed",
//						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
//			}
//		} catch (SQLException sqlEx) {
//			checkAndFireConnectionError(sqlEx);
//		}
//	}
//
//	public void setClob(String parameterName, Clob x) throws SQLException {
//		try {
//			if (this.wrappedStmt != null) {
//				((CallableStatement) this.wrappedStmt)
//						.setClob(parameterName, x);
//			} else {
//				throw SQLError.createSQLException(
//						"No operations allowed after statement closed",
//						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
//			}
//		} catch (SQLException sqlEx) {
//			checkAndFireConnectionError(sqlEx);
//		}
//	}
//
//	public void setClob(String parameterName, Reader reader) throws SQLException {
//		try {
//			if (this.wrappedStmt != null) {
//				((CallableStatement) this.wrappedStmt)
//						.setClob(parameterName, reader);
//			} else {
//				throw SQLError.createSQLException(
//						"No operations allowed after statement closed",
//						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
//			}
//		} catch (SQLException sqlEx) {
//			checkAndFireConnectionError(sqlEx);
//		}
//	}
//
//	public void setClob(String parameterName, Reader reader, long length) throws SQLException {
//		try {
//			if (this.wrappedStmt != null) {
//				((CallableStatement) this.wrappedStmt)
//						.setClob(parameterName, reader, length);
//			} else {
//				throw SQLError.createSQLException(
//						"No operations allowed after statement closed",
//						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
//			}
//		} catch (SQLException sqlEx) {
//			checkAndFireConnectionError(sqlEx);
//		}
//	}
//
//	public void setNCharacterStream(String parameterName, Reader value) throws SQLException {
//		try {
//			if (this.wrappedStmt != null) {
//				((CallableStatement) this.wrappedStmt)
//						.setNCharacterStream(parameterName, value);
//			} else {
//				throw SQLError.createSQLException(
//						"No operations allowed after statement closed",
//						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
//			}
//		} catch (SQLException sqlEx) {
//			checkAndFireConnectionError(sqlEx);
//		}
//	}
//
//	public void setNCharacterStream(String parameterName, Reader value, long length) throws SQLException {
//		try {
//			if (this.wrappedStmt != null) {
//				((CallableStatement) this.wrappedStmt)
//						.setNCharacterStream(parameterName, value, length);
//			} else {
//				throw SQLError.createSQLException(
//						"No operations allowed after statement closed",
//						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
//			}
//		} catch (SQLException sqlEx) {
//			checkAndFireConnectionError(sqlEx);
//		}
//	}
//
//	public void setNClob(String parameterName, NClob value) throws SQLException {
//		try {
//			if (this.wrappedStmt != null) {
//				((CallableStatement) this.wrappedStmt)
//						.setNClob(parameterName, value);
//			} else {
//				throw SQLError.createSQLException(
//						"No operations allowed after statement closed",
//						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
//			}
//		} catch (SQLException sqlEx) {
//			checkAndFireConnectionError(sqlEx);
//		}
//	}
//
//	public void setNClob(String parameterName, Reader reader) throws SQLException {
//		try {
//			if (this.wrappedStmt != null) {
//				((CallableStatement) this.wrappedStmt)
//						.setNClob(parameterName, reader);
//			} else {
//				throw SQLError.createSQLException(
//						"No operations allowed after statement closed",
//						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
//			}
//		} catch (SQLException sqlEx) {
//			checkAndFireConnectionError(sqlEx);
//		}
//	}
//
//	public void setNClob(String parameterName, Reader reader, long length) throws SQLException {
//		try {
//			if (this.wrappedStmt != null) {
//				((CallableStatement) this.wrappedStmt)
//						.setNClob(parameterName, reader, length);
//			} else {
//				throw SQLError.createSQLException(
//						"No operations allowed after statement closed",
//						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
//			}
//		} catch (SQLException sqlEx) {
//			checkAndFireConnectionError(sqlEx);
//		}
//	}
//
//	public void setNString(String parameterName, String value) throws SQLException {
//		try {
//			if (this.wrappedStmt != null) {
//				((CallableStatement) this.wrappedStmt)
//						.setNString(parameterName, value);
//			} else {
//				throw SQLError.createSQLException(
//						"No operations allowed after statement closed",
//						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
//			}
//		} catch (SQLException sqlEx) {
//			checkAndFireConnectionError(sqlEx);
//		}
//	}
//
//	public void setRowId(String parameterName, RowId x) throws SQLException {
//		try {
//			if (this.wrappedStmt != null) {
//				((CallableStatement) this.wrappedStmt)
//						.setRowId(parameterName, x);
//			} else {
//				throw SQLError.createSQLException(
//						"No operations allowed after statement closed",
//						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
//			}
//		} catch (SQLException sqlEx) {
//			checkAndFireConnectionError(sqlEx);
//		}
//	}
//
//	public void setSQLXML(String parameterName, SQLXML xmlObject) throws SQLException {
//		try {
//			if (this.wrappedStmt != null) {
//				((CallableStatement) this.wrappedStmt)
//						.setSQLXML(parameterName, xmlObject);
//			} else {
//				throw SQLError.createSQLException(
//						"No operations allowed after statement closed",
//						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
//			}
//		} catch (SQLException sqlEx) {
//			checkAndFireConnectionError(sqlEx);
//		}
//	}
//
//	public void setAsciiStream(int parameterIndex, InputStream x) throws SQLException {
//		try {
//			if (this.wrappedStmt != null) {
//				((CallableStatement) this.wrappedStmt)
//						.setAsciiStream(parameterIndex, x);
//			} else {
//				throw SQLError.createSQLException(
//						"No operations allowed after statement closed",
//						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
//			}
//		} catch (SQLException sqlEx) {
//			checkAndFireConnectionError(sqlEx);
//		}
//	}
//
//	public void setAsciiStream(int parameterIndex, InputStream x, long length) throws SQLException {
//		try {
//			if (this.wrappedStmt != null) {
//				((CallableStatement) this.wrappedStmt)
//						.setAsciiStream(parameterIndex, x, length);
//			} else {
//				throw SQLError.createSQLException(
//						"No operations allowed after statement closed",
//						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
//			}
//		} catch (SQLException sqlEx) {
//			checkAndFireConnectionError(sqlEx);
//		}
//	}
//
//	public void setBinaryStream(int parameterIndex, InputStream x) throws SQLException {
//		try {
//			if (this.wrappedStmt != null) {
//				((CallableStatement) this.wrappedStmt)
//						.setBinaryStream(parameterIndex, x) ;
//			} else {
//				throw SQLError.createSQLException(
//						"No operations allowed after statement closed",
//						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
//			}
//		} catch (SQLException sqlEx) {
//			checkAndFireConnectionError(sqlEx);
//		}
//	}
//
//	public void setBinaryStream(int parameterIndex, InputStream x, long length) throws SQLException {
//		try {
//			if (this.wrappedStmt != null) {
//				((CallableStatement) this.wrappedStmt)
//						.setBinaryStream(parameterIndex, x, length);
//			} else {
//				throw SQLError.createSQLException(
//						"No operations allowed after statement closed",
//						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
//			}
//		} catch (SQLException sqlEx) {
//			checkAndFireConnectionError(sqlEx);
//		}
//	}
//
//	public void setBlob(int parameterIndex, InputStream inputStream) throws SQLException {
//		try {
//			if (this.wrappedStmt != null) {
//				((CallableStatement) this.wrappedStmt)
//						.setBlob(parameterIndex, inputStream);
//			} else {
//				throw SQLError.createSQLException(
//						"No operations allowed after statement closed",
//						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
//			}
//		} catch (SQLException sqlEx) {
//			checkAndFireConnectionError(sqlEx);
//		}
//	}
//
//	public void setBlob(int parameterIndex, InputStream inputStream, long length) throws SQLException {
//		try {
//			if (this.wrappedStmt != null) {
//				((CallableStatement) this.wrappedStmt)
//						.setBlob(parameterIndex, inputStream, length);
//			} else {
//				throw SQLError.createSQLException(
//						"No operations allowed after statement closed",
//						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
//			}
//		} catch (SQLException sqlEx) {
//			checkAndFireConnectionError(sqlEx);
//		}
//	}
//
//	public void setCharacterStream(int parameterIndex, Reader reader) throws SQLException {
//		try {
//			if (this.wrappedStmt != null) {
//				((CallableStatement) this.wrappedStmt)
//						.setCharacterStream(parameterIndex, reader);
//			} else {
//				throw SQLError.createSQLException(
//						"No operations allowed after statement closed",
//						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
//			}
//		} catch (SQLException sqlEx) {
//			checkAndFireConnectionError(sqlEx);
//		}
//	}
//
//	public void setCharacterStream(int parameterIndex, Reader reader, long length) throws SQLException {
//		try {
//			if (this.wrappedStmt != null) {
//				((CallableStatement) this.wrappedStmt)
//						.getCharacterStream(parameterIndex);
//			} else {
//				throw SQLError.createSQLException(
//						"No operations allowed after statement closed",
//						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
//			}
//		} catch (SQLException sqlEx) {
//			checkAndFireConnectionError(sqlEx);
//		}
//	}
//
//	public void setClob(int parameterIndex, Reader reader) throws SQLException {
//		try {
//			if (this.wrappedStmt != null) {
//				((CallableStatement) this.wrappedStmt)
//						.setClob(parameterIndex, reader);
//			} else {
//				throw SQLError.createSQLException(
//						"No operations allowed after statement closed",
//						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
//			}
//		} catch (SQLException sqlEx) {
//			checkAndFireConnectionError(sqlEx);
//		}
//	}
//
//	public void setClob(int parameterIndex, Reader reader, long length) throws SQLException {
//		try {
//			if (this.wrappedStmt != null) {
//				((CallableStatement) this.wrappedStmt)
//						.setClob(parameterIndex, reader, length);
//			} else {
//				throw SQLError.createSQLException(
//						"No operations allowed after statement closed",
//						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
//			}
//		} catch (SQLException sqlEx) {
//			checkAndFireConnectionError(sqlEx);
//		}
//	}
//
//	public void setNCharacterStream(int parameterIndex, Reader value) throws SQLException {
//		try {
//			if (this.wrappedStmt != null) {
//				((CallableStatement) this.wrappedStmt)
//						.setNCharacterStream(parameterIndex, value);
//			} else {
//				throw SQLError.createSQLException(
//						"No operations allowed after statement closed",
//						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
//			}
//		} catch (SQLException sqlEx) {
//			checkAndFireConnectionError(sqlEx);
//		}
//	
//	}
//
//	public void setNCharacterStream(int parameterIndex, Reader value, long length) throws SQLException {
//		try {
//			if (this.wrappedStmt != null) {
//				((CallableStatement) this.wrappedStmt)
//						.setNCharacterStream(parameterIndex, value, length);
//			} else {
//				throw SQLError.createSQLException(
//						"No operations allowed after statement closed",
//						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
//			}
//		} catch (SQLException sqlEx) {
//			checkAndFireConnectionError(sqlEx);
//		}
//	}
//
//	public void setNClob(int parameterIndex, NClob value) throws SQLException {
//		try {
//			if (this.wrappedStmt != null) {
//				((CallableStatement) this.wrappedStmt)
//						.setNClob(parameterIndex, value);
//			} else {
//				throw SQLError.createSQLException(
//						"No operations allowed after statement closed",
//						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
//			}
//		} catch (SQLException sqlEx) {
//			checkAndFireConnectionError(sqlEx);
//		}
//	}
//
//	public void setNClob(int parameterIndex, Reader reader) throws SQLException {
//		try {
//			if (this.wrappedStmt != null) {
//				((CallableStatement) this.wrappedStmt)
//						.setNClob(parameterIndex, reader);
//			} else {
//				throw SQLError.createSQLException(
//						"No operations allowed after statement closed",
//						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
//			}
//		} catch (SQLException sqlEx) {
//			checkAndFireConnectionError(sqlEx);
//		}
//	}
//
//	public void setNClob(int parameterIndex, Reader reader, long length) throws SQLException {
//		try {
//			if (this.wrappedStmt != null) {
//				((CallableStatement) this.wrappedStmt)
//						.setNClob(parameterIndex, reader, length);
//			} else {
//				throw SQLError.createSQLException(
//						"No operations allowed after statement closed",
//						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
//			}
//		} catch (SQLException sqlEx) {
//			checkAndFireConnectionError(sqlEx);
//		}
//	}
//
//	public void setNString(int parameterIndex, String value) throws SQLException {
//		try {
//			if (this.wrappedStmt != null) {
//				((CallableStatement) this.wrappedStmt)
//						.setNString(parameterIndex, value);
//			} else {
//				throw SQLError.createSQLException(
//						"No operations allowed after statement closed",
//						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
//			}
//		} catch (SQLException sqlEx) {
//			checkAndFireConnectionError(sqlEx);
//		}
//	}
//
//	public void setRowId(int parameterIndex, RowId x) throws SQLException {
//		try {
//			if (this.wrappedStmt != null) {
//				((CallableStatement) this.wrappedStmt)
//						.setRowId(parameterIndex, x);
//			} else {
//				throw SQLError.createSQLException(
//						"No operations allowed after statement closed",
//						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
//			}
//		} catch (SQLException sqlEx) {
//			checkAndFireConnectionError(sqlEx);
//		}
//	}
//
//	public void setSQLXML(int parameterIndex, SQLXML xmlObject) throws SQLException {
//		try {
//			if (this.wrappedStmt != null) {
//				((CallableStatement) this.wrappedStmt)
//						.setSQLXML(parameterIndex, xmlObject);
//			} else {
//				throw SQLError.createSQLException(
//						"No operations allowed after statement closed",
//						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
//			}
//		} catch (SQLException sqlEx) {
//			checkAndFireConnectionError(sqlEx);
//		}
//		
//	}
//
//	public boolean isClosed() throws SQLException {
//		try {
//			if (this.wrappedStmt != null) {
//				return ((CallableStatement) this.wrappedStmt)
//						.isClosed();
//			} else {
//				throw SQLError.createSQLException(
//						"No operations allowed after statement closed",
//						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
//			}
//		} catch (SQLException sqlEx) {
//			checkAndFireConnectionError(sqlEx);
//		}
//		
//		return true;
//	}
//
//	public boolean isPoolable() throws SQLException {
//		try {
//			if (this.wrappedStmt != null) {
//				return ((CallableStatement) this.wrappedStmt)
//						. isPoolable();
//			} else {
//				throw SQLError.createSQLException(
//						"No operations allowed after statement closed",
//						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
//			}
//		} catch (SQLException sqlEx) {
//			checkAndFireConnectionError(sqlEx);
//		}
//		
//		return false;
//	}
//
//	public void setPoolable(boolean poolable) throws SQLException {
//		try {
//			if (this.wrappedStmt != null) {
//				((CallableStatement) this.wrappedStmt)
//						.setPoolable(poolable);
//			} else {
//				throw SQLError.createSQLException(
//						"No operations allowed after statement closed",
//						SQLError.SQL_STATE_GENERAL_ERROR, this.exceptionInterceptor);
//			}
//		} catch (SQLException sqlEx) {
//			checkAndFireConnectionError(sqlEx);
//		}
//		
//	}
//
//	public boolean isWrapperFor(Class arg0) throws SQLException {
//		throw SQLError.notImplemented();
//	}
//
//	public Object unwrap(Class arg0) throws SQLException {
//		throw SQLError.notImplemented();
//	}

    @Override
    public boolean isClosed() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setPoolable(boolean bln) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isPoolable() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void closeOnCompletion() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isCloseOnCompletion() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <T> T unwrap(Class<T> type) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isWrapperFor(Class<?> type) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setRowId(int i, RowId rowid) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setNString(int i, String string) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setNCharacterStream(int i, Reader reader, long l) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setNClob(int i, NClob nclob) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setClob(int i, Reader reader, long l) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setBlob(int i, InputStream in, long l) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setNClob(int i, Reader reader, long l) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setSQLXML(int i, SQLXML sqlxml) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setAsciiStream(int i, InputStream in, long l) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setBinaryStream(int i, InputStream in, long l) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setCharacterStream(int i, Reader reader, long l) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setAsciiStream(int i, InputStream in) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setBinaryStream(int i, InputStream in) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setCharacterStream(int i, Reader reader) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setNCharacterStream(int i, Reader reader) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setClob(int i, Reader reader) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setBlob(int i, InputStream in) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setNClob(int i, Reader reader) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public RowId getRowId(int i) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public RowId getRowId(String string) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setRowId(String string, RowId rowid) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setNString(String string, String string1) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setNCharacterStream(String string, Reader reader, long l) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setNClob(String string, NClob nclob) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setClob(String string, Reader reader, long l) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setBlob(String string, InputStream in, long l) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setNClob(String string, Reader reader, long l) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public NClob getNClob(int i) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public NClob getNClob(String string) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setSQLXML(String string, SQLXML sqlxml) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public SQLXML getSQLXML(int i) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public SQLXML getSQLXML(String string) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getNString(int i) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String getNString(String string) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Reader getNCharacterStream(int i) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Reader getNCharacterStream(String string) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Reader getCharacterStream(int i) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Reader getCharacterStream(String string) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setBlob(String string, Blob blob) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setClob(String string, Clob clob) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setAsciiStream(String string, InputStream in, long l) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setBinaryStream(String string, InputStream in, long l) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setCharacterStream(String string, Reader reader, long l) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setAsciiStream(String string, InputStream in) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setBinaryStream(String string, InputStream in) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setCharacterStream(String string, Reader reader) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setNCharacterStream(String string, Reader reader) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setClob(String string, Reader reader) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setBlob(String string, InputStream in) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void setNClob(String string, Reader reader) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <T> T getObject(int i, Class<T> type) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public <T> T getObject(String string, Class<T> type) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
