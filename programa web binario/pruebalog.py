import sys
sys.path.append('./util/')
from util import logcfg
import logging

logcfg(__file__)
logging.debug("Log para debug")
logging.info("Log para info")
logging.warning("Log para warning")
logging.error("Log para error")
logging.fatal("Log para fatal")